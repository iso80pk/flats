package piotrek.k.flats.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping(value = "/")
	public String allMyRealEstate(Model model) {
		model.addAttribute("realEstateUser",realEstateUserService.getSortedRealEstateUser());
		return "ranking/main";
	}

}
