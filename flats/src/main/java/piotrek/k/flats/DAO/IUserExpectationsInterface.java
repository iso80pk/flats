package piotrek.k.flats.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;

@Repository
public interface IUserExpectationsInterface extends CrudRepository<UserExpectations, Long> {

	public UserExpectations findById(Long id);

	public UserExpectations findByUser(User user);

}