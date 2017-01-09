package piotrek.k.flats.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piotrek.k.flats.DTO.UserDTO;
import piotrek.k.flats.Service.UserService;

@Controller
public class AccessController {
	@Autowired
	private UserService userService;

	@ModelAttribute("form")
	public UserDTO getUserForm() {
		return new UserDTO();
	}

	@RequestMapping(value = "/")
	public String main() {
		return "main/main";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationGet() {
		return "main/registrationForm";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrationPost(@ModelAttribute("form") @Valid UserDTO form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "main/registrationForm";
		}
		boolean email = userService.isUserWithEmail(form.getEmail());
		boolean username = userService.isUserWithUsername(form.getUsername());

		if (email || username) {
			model.addAttribute("email", email);
			model.addAttribute("username", username);
			return "main/registrationForm";
		} else {
			userService.registerUser(form);
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "main/login";
	}
}
