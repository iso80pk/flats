package piotrek.k.flats.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.RealEstateUser;
import piotrek.k.flats.Model.User;

@Repository
public interface IRealEstateUserInterface extends JpaRepository<RealEstateUser, Long> {
	 List<RealEstateUser> findByUserOrderByRankedPosition(User user);
	 List<RealEstateUser> findByUser(User user);
}
