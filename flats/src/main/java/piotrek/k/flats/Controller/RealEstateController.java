package piotrek.k.flats.Controller;

import java.util.LinkedHashMap;
import java.util.Map;

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

import piotrek.k.flats.DTO.RealEsateSearchDataDTO;
import piotrek.k.flats.DTO.RealEstateDTO;
import piotrek.k.flats.Model.RealEstate;
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

	@ModelAttribute("searchData")
	public RealEsateSearchDataDTO searchData() {
		return new RealEsateSearchDataDTO();
	}

	@RequestMapping(value = "/")
	public String allRealEstate(Model model) {
		// User user =
		// userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		model.addAttribute("realEstates", realEstateService.findAll());
		return "realEstate/realEstatesList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String realEstateFormGet(Model model) {
		addRealEstateTypesToModel(model);
		addBooleanTypesToModel(model);
		return "realEstate/realEstateForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String realEstateFormPost(@ModelAttribute("form") @Valid RealEstateDTO form, BindingResult result) {
		if (result.hasErrors())
			return "realEstate/realEstateForm";
		else {
			realEstateService.addRealEstate(form);
			return "redirect:../realEstate/";
		}
	}

	@RequestMapping(value = "/searchData", method = RequestMethod.GET)
	public String searchDataGet() {
		return "realEstate/realEstateSearchDataForm";
	}

	@RequestMapping(value = "/searchData", method = RequestMethod.POST)
	public String searchDataPost(@ModelAttribute("searchData") @Valid RealEsateSearchDataDTO form, Model model) {
		RealEstate realEstate = realEstateService.searchDataInContentOfAdvertisement(form.getText());
		model.addAttribute("form", realEstate);
		addRealEstateTypesToModel(model);
		addBooleanTypesToModel(model);
		return "realEstate/realEstateFormAfterSearchData";
	}

	@RequestMapping(value = "/addAfterSearchData", method = RequestMethod.POST)
	public String realEstateFormAfterSearchDataPost(@ModelAttribute("form") @Valid RealEstateDTO form,
			BindingResult result) {
		if (result.hasErrors())
			return "realEstate/realEstateFormAfterSearchData";
		else {
			realEstateService.addRealEstate(form);
			return "redirect:../realEstate/";
		}
	}

	@RequestMapping(value = "/edit-{id}", method = RequestMethod.GET)
	public String editRealEstateGET(@PathVariable("id") Long id, Model model) {
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else if (!realEstateService.canIEdit(realEstate))
			return "redirect:/403";
		else {
			realEstateService.canIEdit(realEstate);
			model.addAttribute("form", realEstate);
			addRealEstateTypesToModel(model);
			addBooleanTypesToModel(model);
			return "realEstate/realEstateForm";
		}

	}

	@RequestMapping(value = "/edit-{id}", method = RequestMethod.POST)
	public String editRealEstatePOST(@PathVariable("id") Long id, @ModelAttribute("form") @Valid RealEstateDTO form,
			BindingResult result) {
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		else if (!realEstateService.canIEdit(realEstate))
			return "redirect:/403";
		else {
			if (result.hasErrors()) {

				return "realEstate/realEstateForm";
			} else {
				realEstateService.updateRealEstate(realEstate, form);

				return "redirect:../realEstate/details-{id}";
			}

		}
	}

	@RequestMapping(value = "/details-{id}")
	public String realEstateDetails(@PathVariable("id") Long id, Model model) {
		// User user =
		// userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		// else if (!realEstateService.itIsMyRealEstate(user, realEstate))
		// return "redirect:/403";
		else {

			model.addAttribute("realEstate", realEstate);
			return "realEstate/realEstateDetail";
		}
	}

	@RequestMapping(value = "/delete-{id}")
	public String deleteUserById(@PathVariable("id") Long id) {
		// User user =
		// userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		RealEstate realEstate = realEstateService.findById(id);
		if (realEstate == null)
			return "redirect:/404";
		// else if (!realEstateService.itIsMyRealEstate(user, realEstate))
		// return "redirect:/403";
		else {
			realEstateService.delete(id);
			return "redirect:../realEstate/";
		}
	}

	private void addRealEstateTypesToModel(Model model) {
		Map<String, String> realEstateTypes = new LinkedHashMap<String, String>();
		realEstateTypes.put("MIESZKANIE", "MIESZKANIE");
		realEstateTypes.put("DOM", "DOM");
		model.addAttribute("realEstateTypes", realEstateTypes);
	}

	private void addBooleanTypesToModel(Model model) {
		Map<Boolean, String> booleanValues = new LinkedHashMap<Boolean, String>();
		booleanValues.put(null, "Brak informacji");
		booleanValues.put(true, "TAK");
		booleanValues.put(false, "NIE");
		model.addAttribute("booleanValues", booleanValues);
	}

}
