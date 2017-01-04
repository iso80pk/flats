package piotrek.k.flats.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piotrek.k.flats.DTO.EditUserDTO;
import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Service.RolesService;
import piotrek.k.flats.Service.UserService;

@Controller
@RequestMapping(value = "/users")
@Secured({ "ROLE_ADMIN" })
public class UserMenagmentController {

	@Autowired
	private UserService userService;

	@Autowired
	private RolesService rolesService;

	@ModelAttribute("form")
	public EditUserDTO getUserForm() {
		return new EditUserDTO();
	}

	@RequestMapping(value = "/")
	public String showAllUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "userMenagment/users";
	}

	@RequestMapping(value = "/delete-{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		userService.delete(id);
		return "redirect:/users/";
	}

	@RequestMapping(value = "/details-{id}")
	public String userDetails(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		if (user == null)
			return "redirect:/404";
		else {

			model.addAttribute("user", user);
			model.addAttribute("isAdmin", userService.isAdmin(user));
			model.addAttribute("isUser", userService.isUser(user));
			return "userMenagment/userDetails";
		}

	}

	@RequestMapping(value = "/edit-{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		if (user == null)
			return "redirect:/404";
		else {
			model.addAttribute("form", user);
			return "userMenagment/userEditForm";
		}
	}

	@RequestMapping(value = "/edit-{id}", method = RequestMethod.POST)
	public String editUserPOST(@PathVariable("id") Long id, @ModelAttribute("form") @Valid EditUserDTO form,
			BindingResult result) {
		User user = userService.findById(id);
		if (user == null)
			return "redirect:/404";
		else {
			if (result.hasErrors()) {

				return "userMenagment/userEditForm";
			} else {
				user.setFirstName(form.getFirstName());
				user.setLastName(form.getLastName());
				user.setUsername(form.getUsername());
				user.setEmail(form.getEmail());
				user.setEnabled(form.isEnabled());
				user.setPhoneNumber(form.getPhoneNumber());
				userService.addOrUpdate(user);
				return "redirect:/users/details-" + id;
			}
		}
	}

	@RequestMapping(value = "/deleteRole-{id}-{userID}")
	public String deleteRole(@PathVariable("id") Long id, @PathVariable("userID") Long idUser) {
		rolesService.delete(id);
		return "redirect:/users/details-" + idUser;
	}

	@RequestMapping(value = "/addRole-{userId}-{role}")
	public String addRole(@PathVariable("userId") Long id, @PathVariable("role") String role) {
		Roles roles = new Roles();
		roles.setRole(role);
		roles.setUser(userService.findById(id));
		rolesService.addOrUpdate(roles);
		return "redirect:/users/details-" + id;
	}
}
