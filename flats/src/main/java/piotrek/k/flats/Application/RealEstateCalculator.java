package piotrek.k.flats.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import piotrek.k.flats.Application.HelpfulModel.GroupHeplModel;
import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.Priority;
import piotrek.k.flats.Model.RealEstateUser;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;
import piotrek.k.flats.Repository.IImportanceOfExpectationsInterface;
import piotrek.k.flats.Repository.IPriorityRepo;
import piotrek.k.flats.Repository.IRealEstateUserInterface;
import piotrek.k.flats.Repository.IUserExpectationsInterface;

@Component
public class RealEstateCalculator {

	@Autowired
	IUserExpectationsInterface expectationsInterface;

	@Autowired
	IPriorityRepo priorityRepo;

	@Autowired
	IImportanceOfExpectationsInterface iImportanceOfExpectationsInterface;

	@Autowired
	IRealEstateUserInterface estateUserInterface;

	public void calculateAdaptationForAllUserPropositionsByUser(User user) {
		List<Priority> priorities = priorityRepo.findByUser(user);
		List<RealEstateUser> userRE = estateUserInterface.findByUser(user);
		UserExpectations expectations = expectationsInterface.findByUser(user);
		ImportanceOfExpectations importanceOfExpectations = iImportanceOfExpectationsInterface.findByUser(user);

		Map<Integer, List<GroupHeplModel>> groups = getUserExpectationsInCorrectForm(expectations,
				importanceOfExpectations);

		for (RealEstateUser estateUser : userRE) {

			for (Map.Entry<Integer, List<GroupHeplModel>> group : groups.entrySet()) {
				Integer groupDegree = group.getKey();
				List<GroupHeplModel> groupHeplModels = group.getValue();

				for (GroupHeplModel groupHeplModel : groupHeplModels) {

				}
			}
		}

		System.out.println(groups);
	}

	private Map<Integer, List<GroupHeplModel>> getUserExpectationsInCorrectForm(UserExpectations expectations,
			ImportanceOfExpectations importanceOfExpectations) {
		Map<Integer, List<GroupHeplModel>> groups = new HashMap<>();

		if (expectations.getLocation() != null) {
			Integer groupDegree = importanceOfExpectations.getLocation_priority();
			GroupHeplModel model = new GroupHeplModel("Location", importanceOfExpectations.getLocation() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if (expectations.getRealEstateType() != null) {
			Integer groupDegree = importanceOfExpectations.getRealEstateType_priority();
			GroupHeplModel model = new GroupHeplModel("RealEstateType",
					importanceOfExpectations.getRealEstateType() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinFloorArea() != null) || (expectations.getMaxFloorArea() != null)) {
			Integer groupDegree = importanceOfExpectations.getFloorArea_priority();
			GroupHeplModel model = new GroupHeplModel("FloorArea", importanceOfExpectations.getFloorArea() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinPrice() != null) || (expectations.getMaxPrice() != null)) {
			Integer groupDegree = importanceOfExpectations.getPrice_priority();
			GroupHeplModel model = new GroupHeplModel("Price", importanceOfExpectations.getPrice() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinNumberOfRooms() != null) || (expectations.getMaxNumberOfRooms() != null)) {
			Integer groupDegree = importanceOfExpectations.getNumberOfRooms_priority();
			GroupHeplModel model = new GroupHeplModel("NumberOfRooms", importanceOfExpectations.getNumberOfRooms() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinHowOld() != null) || (expectations.getMaxHowOld() != null)) {
			Integer groupDegree = importanceOfExpectations.getHowOld_priority();
			GroupHeplModel model = new GroupHeplModel("HowOld", importanceOfExpectations.getHowOld() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinFloor() != null) || (expectations.getMaxFloor() != null)) {
			Integer groupDegree = importanceOfExpectations.getFloor_priority();
			GroupHeplModel model = new GroupHeplModel("Floor", importanceOfExpectations.getFloor() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if (expectations.getGarage() != null) {
			Integer groupDegree = importanceOfExpectations.getGarage_priority();
			GroupHeplModel model = new GroupHeplModel("Garage", importanceOfExpectations.getGarage() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if (expectations.getParking() != null) {
			Integer groupDegree = importanceOfExpectations.getParking_priority();
			GroupHeplModel model = new GroupHeplModel("Parking", importanceOfExpectations.getParking() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getGarden() != null) {
			Integer groupDegree = importanceOfExpectations.getGarden_priority();
			GroupHeplModel model = new GroupHeplModel("Garden", importanceOfExpectations.getGarden() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getCellar() != null) {
			Integer groupDegree = importanceOfExpectations.getCellar_priority();
			GroupHeplModel model = new GroupHeplModel("Cellar", importanceOfExpectations.getCellar() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getMonitoring() != null) {
			Integer groupDegree = importanceOfExpectations.getMonitoring_priority();
			GroupHeplModel model = new GroupHeplModel("Monitoring", importanceOfExpectations.getMonitoring() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getLift() != null) {
			Integer groupDegree = importanceOfExpectations.getLift_priority();
			GroupHeplModel model = new GroupHeplModel("Lift", importanceOfExpectations.getLift() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getAccessToPublicTransport() != null) {
			Integer groupDegree = importanceOfExpectations.getAccessToPublicTransport_priority();
			GroupHeplModel model = new GroupHeplModel("AccessToPublicTransport",
					importanceOfExpectations.getAccessToPublicTransport() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		for (Map.Entry<Integer, List<GroupHeplModel>> group : groups.entrySet()) {
			List<GroupHeplModel> groupHeplModels = group.getValue();
			Integer sumOfValuesInGroup = 0;
			for (GroupHeplModel groupHeplModel : groupHeplModels) {
				sumOfValuesInGroup += groupHeplModel.getImportanceValue();
			}
			for (GroupHeplModel groupHeplModel : groupHeplModels) {
				groupHeplModel.setSumOfValuesInGroup(sumOfValuesInGroup);
			}

		}
		return groups;
	}

	private void insertGroupModelIntoGroups(Map<Integer, List<GroupHeplModel>> groups, GroupHeplModel model,
			Integer groupDegree) {
		if (!groups.containsKey(groupDegree)) {
			List<GroupHeplModel> groupHeplModel = new ArrayList<>();
			groupHeplModel.add(model);
			groups.put(groupDegree, groupHeplModel);
		} else {
			List<GroupHeplModel> groupHeplModels = groups.get(groupDegree);
			groupHeplModels.add(model);
			groups.put(groupDegree, groupHeplModels);
		}
	}

}
