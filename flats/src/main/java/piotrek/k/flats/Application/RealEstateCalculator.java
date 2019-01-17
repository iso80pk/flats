package piotrek.k.flats.Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import piotrek.k.flats.Application.HelpfulModel.AttributeName;
import piotrek.k.flats.Application.HelpfulModel.GroupHeplModel;
import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.Priority;
import piotrek.k.flats.Model.RealEstate;
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
		if (expectations != null && priorities != null && importanceOfExpectations != null) {

			Map<Integer, List<GroupHeplModel>> groups = getUserExpectationsInCorrectForm(expectations,
					importanceOfExpectations);

			for (RealEstateUser estateUser : userRE) {
				calculateAdaptation(priorities, expectations, groups, estateUser);
			}

			userRE.sort((x1, x2) -> Float.compare(x2.getAdaptation(), x1.getAdaptation()));

			for (int i = 0; i < userRE.size(); i++) {
				userRE.get(i).setRankedPosition(i + 1);
				estateUserInterface.save(userRE.get(i));
			}
		}

		// System.out.println(groups);
	}

	private void calculateAdaptation(List<Priority> priorities, UserExpectations expectations,
			Map<Integer, List<GroupHeplModel>> groups, RealEstateUser estateUser) {
		RealEstate realEstate = estateUser.getRealEstate();
		Boolean fulfillsAllUserExpectation = true;
		Double adaptation = new Double(0);

		for (Map.Entry<Integer, List<GroupHeplModel>> group : groups.entrySet()) {
			Integer groupDegree = group.getKey();
			for (GroupHeplModel groupHeplModel : group.getValue()) {

				switch (groupHeplModel.getName()) {
				case AccessToPublicTransport:
					// no information or not fulfilled user expectation
					if (realEstate.getAccessToPublicTransport() == null
							|| expectations.getAccessToPublicTransport() != realEstate.getAccessToPublicTransport())
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Cellar:
					if (realEstate.getCellar() == null || expectations.getCellar() != realEstate.getCellar())
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Floor:
					if (!isIntegerInTheRange(realEstate.getFloor(), expectations.getMinFloor(),
							expectations.getMaxFloor()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case FloorArea:
					if (!isDoubleInTheRange(realEstate.getFloorArea(), expectations.getMinFloorArea(),
							expectations.getMaxFloorArea())) {
						fulfillsAllUserExpectation = false;
					} else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Garage:
					if (realEstate.getGarage() == null || expectations.getGarage() != realEstate.getGarage())
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Garden:
					if (realEstate.getGarden() == null || expectations.getGarden() != realEstate.getGarden())
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case HowOld:
					if (!isIntegerInTheRange(realEstate.getHowOld(), expectations.getMinHowOld(),
							expectations.getMaxHowOld()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Lift:
					if (realEstate.getLift() == null || !expectations.getLift().equals(realEstate.getLift()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Location:
					if (realEstate.getLocation() == null
							|| !expectations.getLocation().equals(realEstate.getLocation()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Monitoring:
					if (realEstate.getMonitoring() == null
							|| !expectations.getMonitoring().equals(realEstate.getMonitoring()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case NumberOfRooms:
					if (!isIntegerInTheRange(realEstate.getNumberOfRooms(), expectations.getMinNumberOfRooms(),
							expectations.getMaxNumberOfRooms()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Parking:
					if (realEstate.getParking() == null || !expectations.getParking().equals(realEstate.getParking()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case Price:
					if (!isDoubleInTheRange(realEstate.getPrice(), expectations.getMinPrice(),
							expectations.getMaxPrice()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				case RealEstateType:
					if (realEstate.getRealEstateType() == null
							|| !expectations.getRealEstateType().equals(realEstate.getRealEstateType()))
						fulfillsAllUserExpectation = false;
					else {
						Priority priority = getPriorityByGroupDegree(priorities, groupDegree);
						if (priority != null) {
							adaptation += ((new Double(groupHeplModel.getImportanceValue())
									/ new Double(groupHeplModel.getSumOfValuesInGroup())) * priority.getImportance());
						} else {
						}
					}
					break;
				default:
					System.out.println("!!!!  ups  !!!!!");
					break;

				}
			}
		}
		estateUser.setAdaptation(new Float(adaptation));
		estateUser.setFulfillsAllUserExpectation(fulfillsAllUserExpectation);
	}

	private boolean isIntegerInTheRange(Integer value, Integer min, Integer max) {
		if (value == null || (min == null & max == null))
			return false;
		if (min == null)
			return (value <= max);
		else if (max == null)
			return (value >= min);
		else
			return ((value >= min) && (value <= max));
	}

	private boolean isDoubleInTheRange(Double value, Double min, Double max) {
		if (value == null || (min == null & max == null))
			return false;
		if (min == null)
			return (value <= max);
		else if (max == null)
			return (value >= min);
		else
			return ((value >= min) && (value <= max));
	}

	private Priority getPriorityByGroupDegree(List<Priority> priorities, Integer groupDegree) {
		return priorities.stream().filter(x -> x.getDegree().equals(groupDegree)).findFirst().orElse(null);

	}

	public Map<Integer, List<GroupHeplModel>> getUserExpectationsInCorrectForm(UserExpectations expectations,
			ImportanceOfExpectations importanceOfExpectations) {
		Map<Integer, List<GroupHeplModel>> groups = new HashMap<>();

		if (expectations.getLocation() != null) {
			Integer groupDegree = importanceOfExpectations.getLocation_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Location,
					importanceOfExpectations.getLocation() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if (expectations.getRealEstateType() != null) {
			Integer groupDegree = importanceOfExpectations.getRealEstateType_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.RealEstateType,
					importanceOfExpectations.getRealEstateType() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinFloorArea() != null) || (expectations.getMaxFloorArea() != null)) {
			Integer groupDegree = importanceOfExpectations.getFloorArea_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.FloorArea,
					importanceOfExpectations.getFloorArea() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinPrice() != null) || (expectations.getMaxPrice() != null)) {
			Integer groupDegree = importanceOfExpectations.getPrice_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Price, importanceOfExpectations.getPrice() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinNumberOfRooms() != null) || (expectations.getMaxNumberOfRooms() != null)) {
			Integer groupDegree = importanceOfExpectations.getNumberOfRooms_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.NumberOfRooms,
					importanceOfExpectations.getNumberOfRooms() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinHowOld() != null) || (expectations.getMaxHowOld() != null)) {
			Integer groupDegree = importanceOfExpectations.getHowOld_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.HowOld, importanceOfExpectations.getHowOld() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if ((expectations.getMinFloor() != null) || (expectations.getMaxFloor() != null)) {
			Integer groupDegree = importanceOfExpectations.getFloor_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Floor, importanceOfExpectations.getFloor() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if (expectations.getGarage() != null) {
			Integer groupDegree = importanceOfExpectations.getGarage_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Garage, importanceOfExpectations.getGarage() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}

		if (expectations.getParking() != null) {
			Integer groupDegree = importanceOfExpectations.getParking_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Parking, importanceOfExpectations.getParking() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getGarden() != null) {
			Integer groupDegree = importanceOfExpectations.getGarden_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Garden, importanceOfExpectations.getGarden() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getCellar() != null) {
			Integer groupDegree = importanceOfExpectations.getCellar_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Cellar, importanceOfExpectations.getCellar() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getMonitoring() != null) {
			Integer groupDegree = importanceOfExpectations.getMonitoring_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Monitoring,
					importanceOfExpectations.getMonitoring() * 10, null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getLift() != null) {
			Integer groupDegree = importanceOfExpectations.getLift_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.Lift, importanceOfExpectations.getLift() * 10,
					null);
			insertGroupModelIntoGroups(groups, model, groupDegree);
		}
		if (expectations.getAccessToPublicTransport() != null) {
			Integer groupDegree = importanceOfExpectations.getAccessToPublicTransport_priority();
			GroupHeplModel model = new GroupHeplModel(AttributeName.AccessToPublicTransport,
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
