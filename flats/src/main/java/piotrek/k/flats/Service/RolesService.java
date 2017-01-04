package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IRolesInterface;
import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;

@Service
public class RolesService extends BaseService<IRolesInterface, Roles> {

	public List<Roles> findByUserObject(User user) {
		return daoInterface.findByUser(user);
	}

}
