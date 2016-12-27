package piotrek.k.flats.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IUserExpectationsInterface;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;

@Service
public class UserExpectationsService {

	@Autowired
	private IUserExpectationsInterface iUserExpectationsInterface;

	public UserExpectations findById(Long id) {
		return iUserExpectationsInterface.findById(id);
	}

	public UserExpectations findByUser(User user) {
		return iUserExpectationsInterface.findByUser(user);
	}

	public void addUserExpectations(UserExpectations userExpectations) {
		iUserExpectationsInterface.save(userExpectations);
	}

	public void deleteUserExpectations(Long id) {
		iUserExpectationsInterface.delete(id);
	}

}
