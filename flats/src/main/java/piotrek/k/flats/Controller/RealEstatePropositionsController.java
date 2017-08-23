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

import piotrek.k.flats.DTO.RealEstateUserDTO;
import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Service.RealEstateService;
import piotrek.k.flats.Service.RealEstateUserService;
import piotrek.k.flats.Service.UserService;

@RequestMapping(value = "/propositions")
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class RealEstatePropositionsController {

	@Autowired
	UserService userService;

	@Autowired
	private RealEstateService realEstateService;

	@Autowired
	private RealEstateUserService estateUserService;

	@ModelAttribute("form")
	public RealEstateUserDTO getForm() {
		return new RealEstateUserDTO();
	}

	@RequestMapping(value = "/")
	public String notAssignedToMe(Model model) {
		model.addAttribute("realEstates", realEstateService.findNotAssignedToMe());
		return "realEstatePropositions/list";
	}

	@RequestMapping(value = "/add-{id}", method = RequestMethod.GET)
	public String addRealEstateToFollowedGET(@PathVariable("id") Long id, Model model) {

		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else {
			RealEstateUserDTO estateUser = new RealEstateUserDTO();
			model.addAttribute("form", estateUser);
			model.addAttribute("realEstate", realEstate);
			return "realEstatePropositions/addForm";
		}

	}

	@RequestMapping(value = "/add-{id}", method = RequestMethod.POST)
	public String addRealEstateToFollowedPOST(@PathVariable("id") Long id,
			@ModelAttribute("form") @Valid RealEstateUserDTO form, BindingResult result) {
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else {
			if (result.hasErrors()) {
				return "realEstate/realEstateForm";
			} else {
				estateUserService.addRealEstateUser(realEstate, form);
				return "redirect:../ranking/";
			}

		}
	}

}
