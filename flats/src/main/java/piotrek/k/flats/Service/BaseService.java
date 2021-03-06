package piotrek.k.flats.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public abstract class BaseService<T extends JpaRepository<M, Long>,M> {
	
	@Autowired
	public T daoInterface;
	
	public M findById(Long id) {
		return  daoInterface.findOne(id);
	}
	
	public List<M> findAll(){
		return (List<M>) daoInterface.findAll();
	}

	public M addOrUpdate(M model) {
		return daoInterface.save(model);
	}

	public void delete(Long id) {
		daoInterface.delete(id);
	}
	
	
}
