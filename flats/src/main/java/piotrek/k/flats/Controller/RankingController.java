package piotrek.k.flats.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import piotrek.k.flats.Application.RealEstateCalculator;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Service.RealEstateUserService;
import piotrek.k.flats.Service.UserService;

@RequestMapping(value = "/ranking")
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class RankingController {

	@Autowired
	RealEstateUserService realEstateUserService;

	@Autowired
	UserService userService;

	@Autowired
	private RealEstateCalculator calculator;

	@RequestMapping(value = "/")
	public String allMyRealEstate(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		calculator.calculateAdaptationForAllUserPropositionsByUser(user);
		model.addAttribute("realEstateUser", realEstateUserService.getSortedRealEstateUser());
		return "ranking/main";
	}

}
