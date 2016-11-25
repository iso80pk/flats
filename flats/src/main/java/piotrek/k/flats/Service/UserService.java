package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IUserInterface;
import piotrek.k.flats.Model.User;

@Service
public class UserService {
	@Autowired
	IUserInterface iUserInterface;
	
	public List<User> findAllUsers()	{
		return iUserInterface.findAll();
	}
	
	public User getUserById(Long id){
		return iUserInterface.findById(id);
	}
	
	public void addUser(User user){
		iUserInterface.save(user);
	}
	
	public void deleteUser(Long id){
		iUserInterface.delete(id);
	}
	
	public User getByUsername(String username){
		return iUserInterface.findByUsername(username);
	}
	
	public boolean isUserWithEmailOrUsername(String username, String email){
		return ((iUserInterface.findByEmail(email)!=null)||(iUserInterface.findByUsername(username)!=null));
	}
}
