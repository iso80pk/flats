package piotrek.k.flats.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.Priority;
import piotrek.k.flats.Model.User;

@Repository
public interface IPriorityRepo extends  JpaRepository<Priority, Long>{
	Integer countByUser(User user);
	List<Priority> findByUser(User user);

}
