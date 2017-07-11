package piotrek.k.flats.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.Priority;

@Repository
public interface IPriorityRepo extends CrudRepository<Priority, Long>{

}
