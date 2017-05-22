package piotrek.k.flats.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.RealEstateUser;

@Repository
public interface IRealEstateUserInterface extends CrudRepository<RealEstateUser, Long> {

}
