package piotrek.k.flats.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.User;

@Repository
public interface IImportanceOfExpectationsInterface extends JpaRepository<ImportanceOfExpectations, Long> {

	public ImportanceOfExpectations findByUser(User user);

}
