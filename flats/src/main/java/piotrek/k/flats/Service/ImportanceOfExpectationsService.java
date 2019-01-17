package piotrek.k.flats.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DTO.ImportanceOfExpectationsDTO;
import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IImportanceOfExpectationsInterface;

@Service
public class ImportanceOfExpectationsService
		extends BaseService<IImportanceOfExpectationsInterface, ImportanceOfExpectations> {
	@Autowired
	UserService userService;

	@Autowired
	private PriorityService priorityService;

	public ImportanceOfExpectations findByUser(User user) {
		return daoInterface.findByUser(user);
	}

	public void addImportanceOfExpectations(ImportanceOfExpectationsDTO form) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		ImportanceOfExpectations importanceOfExpectations = daoInterface.findByUser(user);
		if (importanceOfExpectations == null) {
			importanceOfExpectations = new ImportanceOfExpectations();
			importanceOfExpectations = initialize(importanceOfExpectations, form);
			importanceOfExpectations.setUser(user);
			importanceOfExpectations = addOrUpdate(importanceOfExpectations);
			priorityService.createFirstPriorityforLoggedUser();
		}
	}

	public void updateImportanceOfExpectations(ImportanceOfExpectations importanceOfExpectations,
			ImportanceOfExpectationsDTO form) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		ImportanceOfExpectations existingImportanceOfExpectations = daoInterface.findByUser(user);
		if (existingImportanceOfExpectations == null) {
			addImportanceOfExpectations(form);
		} else {
			addOrUpdate(initialize(importanceOfExpectations, form));
		}
	}

	private ImportanceOfExpectations initialize(ImportanceOfExpectations importanceOfExpectations,
			ImportanceOfExpectationsDTO form) {
		if (form != null) {
//			if (form.getLocation() != null)
				importanceOfExpectations.setLocation(form.getLocation());
//			if (form.getRealEstateType() != null)
				importanceOfExpectations.setRealEstateType(form.getRealEstateType());
//			if (form.getFloorArea() != null)
				importanceOfExpectations.setFloorArea(form.getFloorArea());
//			if (form.getPrice() != null)
				importanceOfExpectations.setPrice(form.getPrice());
//			if (form.getNumberOfRooms() != null)
				importanceOfExpectations.setNumberOfRooms(form.getNumberOfRooms());
//			if (form.getHowOld() != null)
				importanceOfExpectations.setHowOld(form.getHowOld());
//			if (form.getFloor() != null)
				importanceOfExpectations.setFloor(form.getFloor());
//			if (form.getGarage() != null)
				importanceOfExpectations.setGarage(form.getGarage());
//			if (form.getParking() != null)
				importanceOfExpectations.setParking(form.getParking());
//			if (form.getGarden() != null)
				importanceOfExpectations.setGarden(form.getGarden());
//			if (form.getCellar() != null)
				importanceOfExpectations.setCellar(form.getCellar());
//			if (form.getMonitoring() != null)
				importanceOfExpectations.setMonitoring(form.getMonitoring());
//			if (form.getLift() != null)
				importanceOfExpectations.setLift(form.getLift());
//			if (form.getAccessToPublicTransport() != null)
				importanceOfExpectations.setAccessToPublicTransport(form.getAccessToPublicTransport());
			return importanceOfExpectations;
		}
		return importanceOfExpectations;
	}

}
