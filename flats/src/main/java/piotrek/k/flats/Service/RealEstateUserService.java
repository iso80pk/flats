package piotrek.k.flats.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DTO.RealEstateUserDTO;
import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.RealEstateUser;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IRealEstateUserInterface;

@Service
public class RealEstateUserService extends BaseService<IRealEstateUserInterface, RealEstateUser> {
	@Autowired
	UserService userService;

	public List<RealEstateUser> getSortedRealEstateUser() {
		return daoInterface.findByUserOrderByRankedPosition(
				userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));

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

	public void addRealEstateUser(RealEstate realEstate, RealEstateUserDTO estateUserDTO) {
		RealEstateUser estateUser = new RealEstateUser();
		estateUser.setUser(userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
		estateUser.setRealEstate(realEstate);
		estateUser.setNammedByUser(estateUserDTO.getNammedByUser());
		estateUser.setFavorite(estateUserDTO.getFavorite());
		estateUser.setKmPerDay(estateUserDTO.getKmPerDay());
		estateUser.setMaintenanceCosts(estateUserDTO.getMaintenanceCosts());
		estateUser.setNotes(estateUserDTO.getNotes());
		daoInterface.save(estateUser);
	}
}
