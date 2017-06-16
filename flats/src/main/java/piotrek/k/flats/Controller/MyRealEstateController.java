package piotrek.k.flats.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.RealEstateUser;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IRealEstateInterface;
import piotrek.k.flats.Repository.IRealEstateUserInterface;
import piotrek.k.flats.Service.UserService;

@RequestMapping(value = "/myRealEstate/")
@Controller
@Secured({ "ROLE_USER", "ROLE_ADMIN" })
public class MyRealEstateController {

	@Autowired
	IRealEstateUserInterface iRealEstateUserInterface;
	@Autowired
	IRealEstateInterface iRealEstateInterface;
	@Autowired
	UserService userService;

	@RequestMapping(value = "/")
	public String allMyRealEstate(Model model) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		RealEstateUser realEstateUser = new RealEstateUser();
		realEstateUser.setUser(user);
		RealEstate realEstate = iRealEstateInterface.findOne(1L);
		realEstateUser.setRealEstate(realEstate);
		realEstateUser.setNammedByUser("MARYNA");
		iRealEstateUserInterface.save(realEstateUser);
		return "realEstateUser/myRealEstates";
	}

}
