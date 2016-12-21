package piotrek.k.flats.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piotrek.k.flats.DTO.EditMeDTO;
import piotrek.k.flats.DTO.PasswordDTO;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Service.UserService;

@Controller
@RequestMapping(value = "/aboutMe")
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute("form")
	public EditMeDTO getUserForm() {
		return new EditMeDTO();
	}

	@ModelAttribute("passwordForm")
	public PasswordDTO getPasswordForm() {
		return new PasswordDTO();
	}

	@RequestMapping(value = "/")
	public String aboutMe(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("user", user);
		return "user/aboutMe";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String AboutMeEditGET(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("form", user);
		return "user/editMe";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUserPOST(@ModelAttribute("form") @Valid EditMeDTO form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/editMe";
		} else {
			User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setPhoneNumber(form.getPhoneNumber());
			userService.addUser(user);
			return "redirect:/aboutMe/";
		}
	}

	@RequestMapping(value = "/password", method = RequestMethod.GET)
	public String passwordGET() {
		return "user/changeMyPassword";
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String passwordPOST(@ModelAttribute("passwordForm") @Valid PasswordDTO passwordForm, BindingResult result) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		if (result.hasErrors() || !userService.checkPasword(passwordForm.getOldPassword(), user.getPassword())
				|| !passwordForm.getNewPassword().equals(passwordForm.getRepetedNewPassword())) {
			return "user/changeMyPassword";
		} else {
			user.setPassword(userService.makePasword(passwordForm.getNewPassword()));
			userService.addUser(user);
			return "redirect:/aboutMe/";
		}
	}

}
