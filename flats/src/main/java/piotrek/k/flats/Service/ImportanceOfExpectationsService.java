package piotrek.k.flats.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IImportanceOfExpectationsInterface;
import piotrek.k.flats.DTO.ImportanceOfExpectationsDTO;
import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.User;

@Service
public class ImportanceOfExpectationsService extends BaseService<IImportanceOfExpectationsInterface, ImportanceOfExpectations> {
	@Autowired
	UserService userService;

	public ImportanceOfExpectations findByUser(User user) {
		return daoInterface.findByUser(user);
	}

	public void addImportanceOfExpectations(ImportanceOfExpectationsDTO form) {
		ImportanceOfExpectations importanceOfExpectations = new ImportanceOfExpectations();
		importanceOfExpectations = initialize(importanceOfExpectations, form);
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		importanceOfExpectations.setUser(user);

		addOrUpdate(importanceOfExpectations);
	}

	public void updateImportanceOfExpectations(ImportanceOfExpectations importanceOfExpectations, ImportanceOfExpectationsDTO form) {
		addOrUpdate(initialize(importanceOfExpectations, form));
	}

	private ImportanceOfExpectations initialize(ImportanceOfExpectations importanceOfExpectations, ImportanceOfExpectationsDTO form) {
		importanceOfExpectations.setLocation(form.getLocation());
		importanceOfExpectations.setRealEstateType(form.getRealEstateType());
		importanceOfExpectations.setFloorArea(form.getFloorArea());
		importanceOfExpectations.setPrice(form.getPrice());
		importanceOfExpectations.setNumberOfRooms(form.getNumberOfRooms());
		importanceOfExpectations.setHowOld(form.getHowOld());
		importanceOfExpectations.setFloor(form.getFloor());

		importanceOfExpectations.setGarage(form.getGarage());
		importanceOfExpectations.setParking(form.getParking());
		importanceOfExpectations.setGarden(form.getGarden());
		importanceOfExpectations.setCellar(form.getCellar());
		importanceOfExpectations.setMonitoring(form.getMonitoring());
		importanceOfExpectations.setLift(form.getLift());
		importanceOfExpectations.setAccessToPublicTransport(form.getAccessToPublicTransport());
		return importanceOfExpectations;
	}

}
