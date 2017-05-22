package piotrek.k.flats.Service;

import org.springframework.stereotype.Service;

import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserSituation;
import piotrek.k.flats.Repository.IUserSituationInterface;

@Service
public class UserSituationService extends BaseService<IUserSituationInterface, UserSituation> {

	public UserSituation findByUser(User user) {
		return daoInterface.findByUser(user);
	}

}
