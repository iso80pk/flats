package piotrek.k.flats.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.RealEstate;

@Repository
public interface IRealEstateInterface extends CrudRepository<RealEstate, Long> {

}
