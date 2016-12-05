package piotrek.k.flats.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.User;

@Repository
public interface IRealEstate extends CrudRepository<RealEstate, Long> {

	public RealEstate findById(Long id);
	public List<RealEstate> findByUser(User user);

}
