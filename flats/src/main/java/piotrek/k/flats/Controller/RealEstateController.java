package piotrek.k.flats.Controller;

import java.time.ZonedDateTime;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piotrek.k.flats.DTO.RealEstateDTO;
import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Service.RealEstateService;
import piotrek.k.flats.Service.UserService;

@RequestMapping(value = "/realEstate")
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class RealEstateController {

	@Autowired
	UserService userService;

	@Autowired
	private RealEstateService realEstateService;

	@ModelAttribute("form")
	public RealEstateDTO getStatisticsForm() {
		return new RealEstateDTO();
	}

	@RequestMapping(value = "/")
	public String allMyRealEstate(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("realEstates", realEstateService.findByUser(user));
		return "realEstate/myRealEstates";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String realEstateFormGet(Model model) {
		Map<String, String> realEstateTypes = new LinkedHashMap<String, String>();
		realEstateTypes.put("MIESZKANIE", "MIESZKANIE");
		realEstateTypes.put("DOM", "DOM");
		model.addAttribute("realEstateTypes", realEstateTypes);
		return "realEstate/realEstateForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String realEstateFormPost(@ModelAttribute("form") @Valid RealEstateDTO form, BindingResult result) {
		if (result.hasErrors())
			return "realEstate/realEstateForm";
		else {
			RealEstate realEstate = new RealEstate();
			realEstate.setLocation(form.getLocation());
			realEstate.setRealEstateType(form.getRealEstateType());
			realEstate.setFloorArea(form.getFloorArea());
			realEstate.setPrice(form.getPrice());
			realEstate.setNumberOfRooms(form.getNumberOfRooms());
			realEstate.setHowOld(form.getHowOld());
			realEstate.setGarage(form.getGarage());
			realEstate.setParking(form.getParking());
			realEstate.setGarden(form.getGarden());
			realEstate.setCellar(form.getCellar());
			realEstate.setFloor(form.getFloor());
			realEstate.setMonitoring(form.getMonitoring());
			realEstate.setLift(form.getLift());
			realEstate.setOwnContribution(form.getOwnContribution());
			realEstate.setKmPerDay(form.getKmPerDay());
			realEstate.setMaintenanceCosts(form.getMaintenanceCosts());
			realEstate.setAccessToPublicTransport(form.getAccessToPublicTransport());
			realEstate.setAveragePriceInArea(form.getAveragePriceInArea());
			realEstate.setAdvertismentsLink(form.getAdvertismentsLink());
			realEstate.setNotes(form.getNotes());

			ZonedDateTime zdt = ZonedDateTime.now();
			Date date = Date.from(zdt.toInstant());
			realEstate.setSupplementDate(date);

			User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			realEstate.setUser(user);

			realEstateService.addRealEstate(realEstate);
			return "redirect:../realEstate/";
		}
	}

	@RequestMapping(value = "/edit-{id}", method = RequestMethod.GET)
	public String editRealEstateGET(@PathVariable("id") Long id, Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else if (!realEstateService.itIsMyRealEstate(user, realEstate))
			return "redirect:/403";
		else {
			model.addAttribute("form", realEstate);
			Map<String, String> realEstateTypes = new LinkedHashMap<String, String>();
			realEstateTypes.put("MIESZKANIE", "MIESZKANIE");
			realEstateTypes.put("DOM", "DOM");
			model.addAttribute("realEstateTypes", realEstateTypes);
			return "realEstate/realEstateForm";

		}

	}

	@RequestMapping(value = "/edit-{id}", method = RequestMethod.POST)
	public String editRealEstatePOST(@PathVariable("id") Long id, @ModelAttribute("form") @Valid RealEstateDTO form,
			BindingResult result) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else if (!realEstateService.itIsMyRealEstate(user, realEstate))
			return "redirect:/403";
		else {
			if (result.hasErrors()) {

				return "realEstate/realEstateForm";
			} else {

				realEstate.setLocation(form.getLocation());
				realEstate.setRealEstateType(form.getRealEstateType());
				realEstate.setFloorArea(form.getFloorArea());
				realEstate.setPrice(form.getPrice());
				realEstate.setNumberOfRooms(form.getNumberOfRooms());
				realEstate.setHowOld(form.getHowOld());
				realEstate.setGarage(form.getGarage());
				realEstate.setParking(form.getParking());
				realEstate.setGarden(form.getGarden());
				realEstate.setCellar(form.getCellar());
				realEstate.setFloor(form.getFloor());
				realEstate.setMonitoring(form.getMonitoring());
				realEstate.setLift(form.getLift());
				realEstate.setOwnContribution(form.getOwnContribution());
				realEstate.setKmPerDay(form.getKmPerDay());
				realEstate.setMaintenanceCosts(form.getMaintenanceCosts());
				realEstate.setAccessToPublicTransport(form.getAccessToPublicTransport());
				realEstate.setAveragePriceInArea(form.getAveragePriceInArea());
				realEstate.setAdvertismentsLink(form.getAdvertismentsLink());
				realEstate.setNotes(form.getNotes());

				realEstateService.addRealEstate(realEstate);
				return "redirect:../realEstate/details-{id}";
			}

		}
	}

	@RequestMapping(value = "/details-{id}")
	public String realEstateDetails(@PathVariable("id") Long id, Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else if (!realEstateService.itIsMyRealEstate(user, realEstate))
			return "redirect:/403";
		else {

			model.addAttribute("realEstate", realEstate);
			return "realEstate/realEstateDetail";
		}
	}

	@RequestMapping(value = "/delete-{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else if (!realEstateService.itIsMyRealEstate(user, realEstate))
			return "redirect:/403";
		else {
			realEstateService.deleteRealEstate(id);
			return "redirect:../realEstate/";
		}
	}

}
