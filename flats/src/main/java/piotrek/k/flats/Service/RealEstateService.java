package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IRealEstate;
import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.User;

@Service
public class RealEstateService {
	
	@Autowired
	private IRealEstate iRealEstate;
	
	public RealEstate findById (Long id){
		return iRealEstate.findById(id);
	}
	
	public List<RealEstate> findByUser (User user){
		return iRealEstate.findByUser(user);
	}
	
	public void addRealEstate(RealEstate realEstate){
		iRealEstate.save(realEstate);
	}
	
	public void deleteRealEstate(Long id){
		iRealEstate.delete(id);
	}

}
