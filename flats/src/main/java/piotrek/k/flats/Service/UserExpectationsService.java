package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DTO.UserExpectationsDTO;
import piotrek.k.flats.Model.Priority;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;
import piotrek.k.flats.Repository.IUserExpectationsInterface;

@Service
public class UserExpectationsService extends BaseService<IUserExpectationsInterface, UserExpectations> {

	@Autowired
	UserService userService;

	@Autowired
	PriorityService priorityService;
	
	public UserExpectations findByUser(User user) {
		return daoInterface.findByUser(user);
	}
	
	public List<Priority> getGroupByUser(User user){
		return priorityService.daoInterface.findByUser(user);
	}

	public void addUserExpectations(UserExpectationsDTO form) {
		UserExpectations userExpectations = new UserExpectations();
		userExpectations=initialize(userExpectations, form);
		userExpectations.setUser( userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
		addOrUpdate(userExpectations);
	}
	
	public void updateUserExpectations(UserExpectations userExpectations, UserExpectationsDTO form){
		addOrUpdate(initialize(userExpectations, form));
	}

	private UserExpectations initialize(UserExpectations userExpectations, UserExpectationsDTO form) {
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
		return userExpectations;
	}

}
