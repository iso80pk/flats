package piotrek.k.flats.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

import piotrek.k.flats.Model.ImportanceOfExpectations;
import piotrek.k.flats.Model.Priority;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IPriorityRepo;

@Service
public class PriorityService extends BaseService<IPriorityRepo, Priority> {

	@Autowired
	ImportanceOfExpectationsService importanceOfExpectationsService;

	@Autowired
	UserService userService;

	public void createFirstPriorityforLoggedUser(ImportanceOfExpectations iportance) {
		Integer[] elementCount = firstInitImportanceObject(iportance);
		Boolean zeroGroup = elementCount[3] != 0;
		Integer goupCount = 0;
		for (Integer el : elementCount)
			if (el > 0)
				goupCount++;

		createGroup(goupCount, zeroGroup);
	}

	private void createGroup(Integer goupCount, Boolean zeroGroup) {
		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		if (zeroGroup) {
			Priority priority = new Priority(goupCount, null, 0.0, user);
			daoInterface.save(priority);
			goupCount--;
		}
		int j = 0;
		double k = 0.0;

		for (int i = 1; i < goupCount + 1; i++) {
			j += i * i;
		}
		k = 100.0 / j;
		for (int i = 1; i < goupCount + 1; i++) {
			Priority priority = new Priority(i, null, (k * ((goupCount + 1 - i) * (goupCount + 1 - i))), user);
			daoInterface.save(priority);
		}
	}

	private Integer[] firstInitImportanceObject(ImportanceOfExpectations iportance) {
		Integer[] elementCount = { 0, 0, 0, 0 };

		elementCount[divideInto4DefaultGroups(iportance.getRealEstateType()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getLocation()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getFloorArea()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getPrice()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getNumberOfRooms()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getHowOld()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getFloor()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getGarage()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getParking()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getGarden()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getCellar()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getMonitoring()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getLift()) - 1]++;
		elementCount[divideInto4DefaultGroups(iportance.getAccessToPublicTransport()) - 1]++;

		Map<Integer, Integer> max = new HashMap<Integer, Integer>();
		Integer goupCount = 0;
		if (elementCount[0] > 0) {
			goupCount++;
			max.put(goupCount, 7);
		}
		if (elementCount[1] > 0) {
			goupCount++;
			max.put(goupCount, 4);
		}
		if (elementCount[2] > 0) {
			goupCount++;
			max.put(goupCount, 0);
		}
		if (elementCount[3] > 0) {
			goupCount++;
			max.put(goupCount, -1);
		}

		iportance.setLocation_priority(getGroup(max, goupCount, iportance.getLocation()));
		iportance.setRealEstateType_priority(getGroup(max, goupCount, iportance.getRealEstateType()));
		iportance.setFloorArea_priority(getGroup(max, goupCount, iportance.getFloorArea()));
		iportance.setPrice_priority(getGroup(max, goupCount, iportance.getPrice()));
		iportance.setNumberOfRooms_priority(getGroup(max, goupCount, iportance.getNumberOfRooms()));
		iportance.setHowOld_priority(getGroup(max, goupCount, iportance.getHowOld()));
		iportance.setFloor_priority(getGroup(max, goupCount, iportance.getFloor()));
		iportance.setGarage_priority(getGroup(max, goupCount, iportance.getGarage()));
		iportance.setParking_priority(getGroup(max, goupCount, iportance.getParking()));
		iportance.setGarden_priority(getGroup(max, goupCount, iportance.getGarden()));
		iportance.setCellar_priority(getGroup(max, goupCount, iportance.getCellar()));
		iportance.setMonitoring_priority(getGroup(max, goupCount, iportance.getMonitoring()));
		iportance.setLift_priority(getGroup(max, goupCount, iportance.getLift()));
		iportance.setAccessToPublicTransport_priority(getGroup(max, goupCount, iportance.getAccessToPublicTransport()));
		importanceOfExpectationsService.daoInterface.save(iportance);

		return elementCount;
	}

	private Integer getGroup(Map<Integer, Integer> max, Integer goupCount, Integer importance) {
		if (importance == null)
			return goupCount;

		for (Map.Entry<Integer, Integer> pair : max.entrySet()) {
			if (importance > pair.getValue())
				return pair.getKey();
		}
		return goupCount;
	}

	// 100-80, 70-50, 40-10, 0
	private Integer divideInto4DefaultGroups(Integer importance) {
		System.out.println(importance);
		if (importance == null)
			return 4;
		if (importance > 7)
			return 1;
		if (importance > 4)
			return 2;
		if (importance > 0)
			return 3;
		else
			return 4;
	}

}
