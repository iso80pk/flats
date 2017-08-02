package piotrek.k.flats.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.Model.RealEstateUser;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IRealEstateUserInterface;

@Service
public class RealEstateUserService extends BaseService<IRealEstateUserInterface, RealEstateUser> {
	@Autowired
	UserService userService;

	public List<RealEstateUser> getSortedRealEstateUser(){
		return daoInterface.findByUserOrderByRankedPosition(userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
		
	}
	
	public List<RealEstateUser> getRealEstate_UserLoggedUser() {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<RealEstateUser> estateUsers = user.getRealEstateUsers();
		Set<RealEstateUser> hs = new HashSet<RealEstateUser>();
		hs.addAll(estateUsers);
		estateUsers.clear();
		estateUsers.addAll(hs);
		return estateUsers;
	}
}
