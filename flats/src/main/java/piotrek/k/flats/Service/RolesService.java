package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import piotrek.k.flats.Model.Roles;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IRolesInterface;

@Service
public class RolesService extends BaseService<IRolesInterface, Roles> {

	public List<Roles> findByUserObject(User user) {
		return daoInterface.findByUser(user);
	}

}
