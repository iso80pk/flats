package piotrek.k.flats.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IImportanceOfExpectationsInterface;
import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.User;

@Service
public class ImportanceOfExpectationsService {

	@Autowired
	IImportanceOfExpectationsInterface iImportanceOfExpectationsInterface;
	
	public ImportanceOfExpectations  findById(Long id) {
		return iImportanceOfExpectationsInterface.findById(id);
	}

	public ImportanceOfExpectations findByUser(User user) {
		return iImportanceOfExpectationsInterface.findByUser(user);
	}

	public void addImportanceOfExpectations(ImportanceOfExpectations importanceOfExpectations) {
		iImportanceOfExpectationsInterface.save(importanceOfExpectations);
	}

	public void deleteImportanceOfExpectations(Long id) {
		iImportanceOfExpectationsInterface.delete(id);
	}
}
