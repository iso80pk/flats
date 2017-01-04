package piotrek.k.flats.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserSituation;

@Repository
public interface IUserSituationInterface extends CrudRepository<UserSituation, Long> {

	public UserSituation findByUser(User user);

}