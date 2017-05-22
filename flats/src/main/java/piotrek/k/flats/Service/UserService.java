package piotrek.k.flats.Service;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DTO.UserDTO;
import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IUserInterface;

@Service
public class UserService extends BaseService<IUserInterface, User> {

	@Autowired
	RolesService rolesService;

	public User getByUsername(String username) {
		return daoInterface.findByUsername(username);
	}

	public void registerUser(UserDTO form) {

		User user = new User();
		user.setFirstName(form.getFirstName());
		user.setLastName(form.getLastName());
		user.setUsername(form.getUsername());
		user.setEmail(form.getEmail());
		user.setPassword(makePasword((form.getPassword())));
		user.setEnabled(true);
		user.setPhoneNumber(form.getPhoneNumber());
		ZonedDateTime zdt = ZonedDateTime.now();
		Date date = Date.from(zdt.toInstant());
		user.setSignUpDate(date);
		addOrUpdate(user);

		Roles roles = new Roles();
		roles.setUser(getByUsername(form.getUsername()));
		roles.setRole("ROLE_USER");
		rolesService.addOrUpdate(roles);

	}

	public boolean isUserWithEmail(String email) {
		return (daoInterface.findByEmail(email) != null);
	}
	
	public boolean isUserWithUsername(String username) {
		return (daoInterface.findByUsername(username) != null);
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
