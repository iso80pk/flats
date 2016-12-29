package piotrek.k.flats.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.User;

@Repository
public interface IImportanceOfExpectationsInterface extends CrudRepository<ImportanceOfExpectations, Long> {

			public ImportanceOfExpectations findById(Long id);
			public ImportanceOfExpectations findByUser(User user);

		}

