package piotrek.k.flats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.User;

@Repository
public interface IUserInterface extends JpaRepository<User, Long> {

	public User findByUsername(String username);

	public User findByEmail(String email);
}
