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

import piotrek.k.flats.DTO.ImportanceOfExpectationsDTO;
import piotrek.k.flats.DTO.UserExpectationsDTO;
import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;
import piotrek.k.flats.Service.ImportanceOfExpectationsService;
import piotrek.k.flats.Service.UserExpectationsService;
import piotrek.k.flats.Service.UserService;

@RequestMapping(value = "/userExpectations")
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class UserExpectationsController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserExpectationsService userExpectationsService;
	
	@Autowired
	private ImportanceOfExpectationsService importanceOfExpectationsService;

	@ModelAttribute("form")
	public UserExpectationsDTO getStatisticsForm() {
		return new UserExpectationsDTO();
	}
	
	@ModelAttribute("importanceForm")
	public ImportanceOfExpectationsDTO getImportanceForm() {
		return new ImportanceOfExpectationsDTO();
	}

	@RequestMapping(value = "/")
	public String userExpectationsDetail(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("userExpectations", userExpectationsService.findByUser(user));
		model.addAttribute("importanceOfExpectations", importanceOfExpectationsService.findByUser(user));
		return "userExpectations/userExpectationsDetail";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String userExpectationsFormGET(Model model) {
		Map<String, String> realEstateTypes = new LinkedHashMap<String, String>();
		realEstateTypes.put("MIESZKANIE", "MIESZKANIE");
		realEstateTypes.put("DOM", "DOM");
		model.addAttribute("realEstateTypes", realEstateTypes);
		return "userExpectations/userExpectationsForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String userExpectationsFormPOST(@ModelAttribute("form") @Valid UserExpectationsDTO form, BindingResult result) {
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
			
			return "redirect:/userExpectations/addImportanceOfExpectations";
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
	
	@RequestMapping(value = "/addImportanceOfExpectations", method = RequestMethod.GET)
	public String addImportanceOfExpectationsGET(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		UserExpectations userExpectations = userExpectationsService.findByUser(user);
		model.addAttribute("userExpectations", userExpectations);
		
		return "userExpectations/userImportanceOfExpectationsForm";
	}

	
	@RequestMapping(value = "/addImportanceOfExpectations", method = RequestMethod.POST)
	public String addImportanceOfExpectationsPOST(@ModelAttribute("importanceForm") @Valid ImportanceOfExpectationsDTO form, BindingResult result) {
		if (result.hasErrors())
			return "userExpectations/userImportanceOfExpectationsForm";
		else {
			ImportanceOfExpectations importanceOfExpectations = new ImportanceOfExpectations();
			importanceOfExpectations.setLocation(form.getLocation());
			importanceOfExpectations.setRealEstateType(form.getRealEstateType());
			importanceOfExpectations.setFloorArea(form.getFloorArea());
			importanceOfExpectations.setPrice(form.getPrice());
			importanceOfExpectations.setNumberOfRooms(form.getNumberOfRooms());
			importanceOfExpectations.setHowOld(form.getHowOld());
			importanceOfExpectations.setFloor(form.getFloor());
			
			importanceOfExpectations.setGarage(form.getGarage());
			importanceOfExpectations.setParking(form.getParking());
			importanceOfExpectations.setGarden(form.getGarden());
			importanceOfExpectations.setCellar(form.getCellar());
			importanceOfExpectations.setMonitoring(form.getMonitoring());
			importanceOfExpectations.setLift(form.getLift());
			importanceOfExpectations.setAccessToPublicTransport(form.getAccessToPublicTransport());

			User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
			importanceOfExpectations.setUser(user);

			importanceOfExpectationsService.addImportanceOfExpectations(importanceOfExpectations);
			
			return "redirect:/userExpectations/";
		}
	}
	
	@RequestMapping(value = "/editImportanceOfExpectations", method = RequestMethod.GET)
	public String editImportanceOfExpectationsGET(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		ImportanceOfExpectations importanceOfExpectations = importanceOfExpectationsService.findByUser(user);
		if (importanceOfExpectations == null)
			return "redirect:/userExpectations/addImportanceOfExpectations";
		else {
			UserExpectations userExpectations = userExpectationsService.findByUser(user);
			model.addAttribute("userExpectations", userExpectations);
			model.addAttribute("importanceForm", importanceOfExpectations);
			return "userExpectations/userImportanceOfExpectationsForm";
		}
		
	}

	
	@RequestMapping(value = "/editImportanceOfExpectations", method = RequestMethod.POST)
	public String editImportanceOfExpectationsPOST(@ModelAttribute("importanceForm") @Valid ImportanceOfExpectationsDTO form, BindingResult result) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		ImportanceOfExpectations importanceOfExpectations = importanceOfExpectationsService.findByUser(user);
		if (importanceOfExpectations ==null){
			return "redirect:/userExpectations/addImportanceOfExpectations";
		}
				
		if (result.hasErrors())
			return "userExpectations/userImportanceOfExpectationsForm";
		else {
			importanceOfExpectations.setLocation(form.getLocation());
			importanceOfExpectations.setRealEstateType(form.getRealEstateType());
			importanceOfExpectations.setFloorArea(form.getFloorArea());
			importanceOfExpectations.setPrice(form.getPrice());
			importanceOfExpectations.setNumberOfRooms(form.getNumberOfRooms());
			importanceOfExpectations.setHowOld(form.getHowOld());
			importanceOfExpectations.setFloor(form.getFloor());
			
			importanceOfExpectations.setGarage(form.getGarage());
			importanceOfExpectations.setParking(form.getParking());
			importanceOfExpectations.setGarden(form.getGarden());
			importanceOfExpectations.setCellar(form.getCellar());
			importanceOfExpectations.setMonitoring(form.getMonitoring());
			importanceOfExpectations.setLift(form.getLift());
			importanceOfExpectations.setAccessToPublicTransport(form.getAccessToPublicTransport());
			
			importanceOfExpectations.setUser(user);

			importanceOfExpectationsService.addImportanceOfExpectations(importanceOfExpectations);
			
			return "redirect:/userExpectations/";
			
		}
	}
	
	
}
