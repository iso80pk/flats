package piotrek.k.flats.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

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

import piotrek.k.flats.DTO.UserExpectationsDTO;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;
import piotrek.k.flats.Service.UserExpectationsService;
import piotrek.k.flats.Service.UserService;

@RequestMapping(value = "/userExpectations")
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class UserExpectationsController {

	@Autowired
	UserService userService;

	@Autowired
	private UserExpectationsService userExpectationsService;

	@ModelAttribute("form")
	public UserExpectationsDTO getStatisticsForm() {
		return new UserExpectationsDTO();
	}

	@RequestMapping(value = "/")
	public String userExpectationsDetail(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("userExpectations", userExpectationsService.findByUser(user));
		return "userExpectations/userExpectationsDetail";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String userExpectationsFormGet(Model model) {
		Map<String, String> realEstateTypes = new LinkedHashMap<String, String>();
		realEstateTypes.put("MIESZKANIE", "MIESZKANIE");
		realEstateTypes.put("DOM", "DOM");
		model.addAttribute("realEstateTypes", realEstateTypes);
		return "userExpectations/userExpectationsForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String userExpectationsFormPost(@ModelAttribute("form") @Valid UserExpectationsDTO form, BindingResult result) {
		if (result.hasErrors())
			return "userExpectations/userExpectationsForm";
		else {
			UserExpectations userExpectations = new UserExpectations();
			userExpectations.setLocation(form.getLocation());
			userExpectations.setRealEstateType(form.getRealEstateType());
			userExpectations.setMinFloorArea(form.getMinFloorArea());
			userExpectations.setMaxFloorArea(form.getMaxFloorArea());

			userExpectations.setMinPrice(form.getMinPrice());
			userExpectations.setMaxPrice(form.getMaxPrice());

			userExpectations.setMinNumberOfRooms(form.getMinNumberOfRooms());
			userExpectations.setMaxNumberOfRooms(form.getMaxNumberOfRooms());

			userExpectations.setMinHowOld(form.getMinHowOld());
			userExpectations.setMaxHowOld(form.getMaxHowOld());

			userExpectations.setMinFloor(form.getMinFloor());
			userExpectations.setMaxFloor(form.getMaxFloor());

			userExpectations.setGarage(form.getGarage());
			userExpectations.setParking(form.getParking());
			userExpectations.setGarden(form.getGarden());
			userExpectations.setCellar(form.getCellar());
			userExpectations.setMonitoring(form.getMonitoring());
			userExpectations.setLift(form.getLift());
			userExpectations.setAccessToPublicTransport(form.getAccessToPublicTransport());

			User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			userExpectations.setUser(user);

			userExpectationsService.addUserExpectations(userExpectations);
			
			return "redirect:/userExpectations/";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editUserExpectationsGET(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		UserExpectations userExpectations = userExpectationsService.findByUser(user);
		if (userExpectations == null)
			return "redirect:/404";

		else {
			model.addAttribute("form", userExpectations);
			Map<String, String> realEstateTypes = new LinkedHashMap<String, String>();
			realEstateTypes.put("MIESZKANIE", "MIESZKANIE");
			realEstateTypes.put("DOM", "DOM");
			model.addAttribute("realEstateTypes", realEstateTypes);
			return "userExpectations/userExpectationsForm";

		}

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUserExpectationsPOST(@ModelAttribute("form") @Valid UserExpectationsDTO form,
			BindingResult result) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		UserExpectations userExpectations = userExpectationsService.findByUser(user);
		if (userExpectations == null)
			return "redirect:/404";
		else {
			if (result.hasErrors()) {
				return "userExpectations/userExpectationsForm";
			} else {
				userExpectations.setLocation(form.getLocation());
				userExpectations.setRealEstateType(form.getRealEstateType());
				userExpectations.setMinFloorArea(form.getMinFloorArea());
				userExpectations.setMaxFloorArea(form.getMaxFloorArea());

				userExpectations.setMinPrice(form.getMinPrice());
				userExpectations.setMaxPrice(form.getMaxPrice());

				userExpectations.setMinNumberOfRooms(form.getMinNumberOfRooms());
				userExpectations.setMaxNumberOfRooms(form.getMaxNumberOfRooms());

				userExpectations.setMinHowOld(form.getMinHowOld());
				userExpectations.setMaxHowOld(form.getMaxHowOld());

				userExpectations.setMinFloor(form.getMinFloor());
				userExpectations.setMaxFloor(form.getMaxFloor());

				userExpectations.setGarage(form.getGarage());
				userExpectations.setParking(form.getParking());
				userExpectations.setGarden(form.getGarden());
				userExpectations.setCellar(form.getCellar());
				userExpectations.setMonitoring(form.getMonitoring());
				userExpectations.setLift(form.getLift());
				userExpectations.setAccessToPublicTransport(form.getAccessToPublicTransport());

				userExpectationsService.addUserExpectations(userExpectations);
				return "redirect:/userExpectations/";
			}

		}
	}

}
