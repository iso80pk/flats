package piotrek.k.flats.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;

@Repository
public interface IRolesInterface extends CrudRepository<Roles, Long> {

	public List<Roles> findByUser(User user);

}
