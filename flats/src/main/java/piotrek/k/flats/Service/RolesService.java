package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IRolesInterface;
import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;

@Service
public class RolesService {
	@Autowired
	IRolesInterface iRolesInterface;

	public Roles findById(Long id) {
		return iRolesInterface.findById(id);
	}

	public List<Roles> findByAll() {
		return iRolesInterface.findAll();
	}
	
	public List<Roles> findByUserObject(User user){
		return iRolesInterface.findByUser(user);
	}
	
	public void saveRole(Roles roles){
		iRolesInterface.save(roles);
	}
	
	public void deleteRole(Long id){
		iRolesInterface.delete(id);
	}
}
