package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IUserInterface;
import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;

@Service
public class UserService {
	@Autowired
	IUserInterface iUserInterface;

	public List<User> findAllUsers() {
		return iUserInterface.findAll();
	}

	public User getUserById(Long id) {
		return iUserInterface.findById(id);
	}

	public void addUser(User user) {
		iUserInterface.save(user);
	}

	public void deleteUser(Long id) {
		iUserInterface.delete(id);
	}

	public User getByUsername(String username) {
		return iUserInterface.findByUsername(username);
	}

	public boolean isUserWithEmailOrUsername(String username, String email) {
		return ((iUserInterface.findByEmail(email) != null) || (iUserInterface.findByUsername(username) != null));
	}

	public Roles isAdmin(User user) {
		for (Roles role : user.getRoles())
			if (role.getRole().equals("ROLE_ADMIN"))
				return role;
		return null;
	}

	public Roles isUser(User user) {
		for (Roles role : user.getRoles())
			if (role.getRole().equals("ROLE_USER"))
				return role;
		return null;
	}

	public String makePasword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}

	public boolean checkPasword(String password, String encodedPassword) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.matches(password, encodedPassword);
	}
}
