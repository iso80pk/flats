package piotrek.k.flats.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IUserSituationInterface;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserSituation;

@Service
public class UserSituationService {

	@Autowired
	private IUserSituationInterface iUserSituationInterface;
	
	public UserSituation findById(Long id) {
		return iUserSituationInterface.findById(id);
	}

	public UserSituation findByUser(User user) {
		return iUserSituationInterface.findByUser(user);
	}

	public void addUserSituation(UserSituation userSituation) {
		iUserSituationInterface.save(userSituation);
	}

	public void deleteUserSituation(Long id) {
		iUserSituationInterface.delete(id);
	}
	
}
