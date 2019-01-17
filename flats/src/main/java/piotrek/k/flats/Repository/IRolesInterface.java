package piotrek.k.flats.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;

@Repository
public interface IRolesInterface extends JpaRepository<Roles, Long> {

	public List<Roles> findByUser(User user);

}
