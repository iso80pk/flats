package piotrek.k.flats.Controller;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piotrek.k.flats.DTO.UserDTO;
import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Service.RolesService;
import piotrek.k.flats.Service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RolesService rolesService;

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
		if (result.hasErrors()||userService.isUserWithEmailOrUsername(form.getUsername(), form.getEmail()))
			return "registrationForm";
		else {
			User user=new User();
			Roles roles = new Roles();
			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setUsername(form.getUsername());
			user.setEmail(form.getEmail());
			user.setPassword(makePasword(form.getPassword()));
			user.setEnabled(true);
			user.setPhoneNumber(form.getPhoneNumber());
			//user.setRole("ROLE_USER");
			ZonedDateTime zdt = ZonedDateTime.now();
			Date date = Date.from(zdt.toInstant());
			user.setSignUpDate(date);
			userService.addUser(user);
			user= userService.getByUsername(form.getUsername());
			roles.setUser(user);
			roles.setRole("ROLE_USER");
			rolesService.saveRole(roles);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/login",	method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	private String makePasword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
}
