package piotrek.k.flats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;

@Repository
public interface IUserExpectationsInterface extends JpaRepository<UserExpectations, Long> {

	public UserExpectations findByUser(User user);

}