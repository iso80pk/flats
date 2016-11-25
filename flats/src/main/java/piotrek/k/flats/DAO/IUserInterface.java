package piotrek.k.flats.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.User;

@Repository
public interface IUserInterface extends CrudRepository<User, Long> {
	public User findById(Long id);
	public List<User> findAll();
	public User findByUsername(String username);
	public User findByEmail(String email);
}
