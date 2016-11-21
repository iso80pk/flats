package piotrek.k.flats.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piotrek.k.flats.DTO.UserDTO;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute("form")
	public UserDTO getUserForm() {
		return new UserDTO();
	}
	
	@RequestMapping(value="/")
	public String main() {
		return "main";
	}
	
	@RequestMapping(value="/registration",	method = RequestMethod.GET)
	public String registrationGet() {
		return "registrationForm";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrationPost(@ModelAttribute("form") @Valid UserDTO form, BindingResult result) {
		if (result.hasErrors())
			return "registrationForm";
		else {
			User user=new User();
			user.setUsername(form.getUsername());
			user.setPassword(form.getPassword());
			user.setEnabled(true);
			userService.addUser(user);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/login",	method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}
