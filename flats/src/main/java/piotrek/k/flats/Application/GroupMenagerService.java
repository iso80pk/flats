package piotrek.k.flats.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import piotrek.k.flats.Application.HelpfulModel.AttributeName;
import piotrek.k.flats.Application.HelpfulModel.GroupHeplModel;
import piotrek.k.flats.DTO.REST.Attributes;
import piotrek.k.flats.DTO.REST.Group;
import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.Priority;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Model.UserExpectations;
import piotrek.k.flats.Repository.IPriorityRepo;
import piotrek.k.flats.Repository.IUserExpectationsInterface;
import piotrek.k.flats.Service.ImportanceOfExpectationsService;
import piotrek.k.flats.Service.PriorityService;
import piotrek.k.flats.Service.UserService;

@Service
public class GroupMenagerService {

	@Autowired
	ImportanceOfExpectationsService importanceOfExpectationsService;

	@Autowired
	UserService userService;

	@Autowired
	IPriorityRepo priorityRepo;
	@Autowired
	IUserExpectationsInterface expectationsInterface;
	@Autowired
	RealEstateCalculator RECalcularor;
	@Autowired
	PriorityService priorityService;

	public Map<Integer, Group> saveGroups(Map<Integer, Group> groups) {

		groups.entrySet().removeIf(group -> CollectionUtils.isEmpty(group.getValue().getAtributes()));
		groups.forEach((key, value) -> {
			value.setDegree(key);
		});

		List<Group> groupList = new ArrayList<>();
//		groups.values().forEach(a -> groupList.add(a));
		for (Group group : groups.values()) {
			if (group != null) {
				groupList.add(group);
			}
		}

		Optional<Group> zeroGroup = groupList.stream().filter(x -> x.getImportance() != null && x.getImportance().equals(0.0))
				.findFirst();
		if (zeroGroup.isPresent()) {

			Collections.swap(groupList, groupList.indexOf(zeroGroup.get()), groupList.size() - 1);
		}

		groupList.stream().sorted(Comparator.comparing(Group::getImportance)).collect(Collectors.toList());

		updateUserImportancePriorities(groupList);

		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		priorityService.daoInterface.delete(priorityService.daoInterface.findByUser(user));
		priorityService.createGroup(groupList.size(), zeroGroup.isPresent(), user);
		// System.out.println(groupList);
		return getGroupsByLoggedUser();
	}

	private void updateUserImportancePriorities(List<Group> groupList) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		ImportanceOfExpectations iportance = importanceOfExpectationsService.findByUser(user);

		iportance.setLocation_priority(getPriority(AttributeName.Location, groupList));
		iportance.setRealEstateType_priority(getPriority(AttributeName.RealEstateType, groupList));
		iportance.setFloorArea_priority(getPriority(AttributeName.FloorArea, groupList));
		iportance.setPrice_priority(getPriority(AttributeName.Price, groupList));
		iportance.setNumberOfRooms_priority(getPriority(AttributeName.NumberOfRooms, groupList));
		iportance.setHowOld_priority(getPriority(AttributeName.HowOld, groupList));
		iportance.setFloor_priority(getPriority(AttributeName.Floor, groupList));
		iportance.setGarage_priority(getPriority(AttributeName.Garage, groupList));
		iportance.setParking_priority(getPriority(AttributeName.Parking, groupList));
		iportance.setGarden_priority(getPriority(AttributeName.Garden, groupList));
		iportance.setCellar_priority(getPriority(AttributeName.Cellar, groupList));
		iportance.setMonitoring_priority(getPriority(AttributeName.Monitoring, groupList));
		iportance.setLift_priority(getPriority(AttributeName.Lift, groupList));
		iportance.setAccessToPublicTransport_priority(getPriority(AttributeName.AccessToPublicTransport, groupList));
		importanceOfExpectationsService.daoInterface.saveAndFlush(iportance);
	}

	private Integer getPriority(AttributeName name, List<Group> groupList) {
		for (Group group : groupList) {
			for (Attributes atribut : group.getAtributes()) {
				if (atribut.getName().equals(name.getValue())) {
					return group.getDegree();
				}
			}
		}
		return 0;
	}

	public Map<Integer, Group> getGroupsByLoggedUser() {

		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		List<Priority> userPriorities = priorityRepo.findByUser(user);
		List<Group> groups = new ArrayList<>();

		UserExpectations expectations = expectationsInterface.findByUser(user);
		ImportanceOfExpectations importances = importanceOfExpectationsService.findByUser(user);

		for (Priority priority : userPriorities) {
			Group group = new Group();
			BeanUtils.copyProperties(priority, group);
			groups.add(group);
		}

		Map<Integer, List<GroupHeplModel>> groupsInCorrectForm = RECalcularor
				.getUserExpectationsInCorrectForm(expectations, importances);

		List<AttributeName> allAtributes = new ArrayList<>(Arrays.asList(AttributeName.class.getEnumConstants()));

		for (Map.Entry<Integer, List<GroupHeplModel>> groupDetails : groupsInCorrectForm.entrySet()) {
			Integer groupDegree = groupDetails.getKey();
			Group group = groups.stream().filter(x -> x.getDegree().equals(groupDegree)).findFirst().orElse(null);
			List<Attributes> atributes = new ArrayList<>();
			for (GroupHeplModel groupHeplModel : groupDetails.getValue()) {
				atributes.add(new Attributes(groupHeplModel.getName().getValue(), groupHeplModel.getImportanceValue()));
				allAtributes.remove(groupHeplModel.getName());

			}
			group.setAtributes(atributes);
		}

		groups = groups.stream().sorted(Comparator.comparing(Group::getDegree)).collect(Collectors.toList());
		if (!allAtributes.isEmpty()) {
			Group lastgroup = groups.get(groups.size() - 1);
			List<Attributes> atributes = (lastgroup.getAtributes() == null) ? new ArrayList<>()
					: lastgroup.getAtributes();

			allAtributes.forEach(art -> atributes.add(new Attributes(art.getValue(), 0)));

			lastgroup.setAtributes(atributes);
		}
		return groups.stream().collect(Collectors.toMap(Group::getDegree, Function.identity()));

	}

}
