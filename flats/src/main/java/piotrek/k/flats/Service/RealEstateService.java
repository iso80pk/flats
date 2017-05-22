package piotrek.k.flats.Service;

import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.stereotype.Service;

import piotrek.k.flats.DTO.RealEstateDTO;
import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IRealEstateInterface;

@Service
public class RealEstateService extends BaseService<IRealEstateInterface, RealEstate> {

	public boolean itIsMyRealEstate(User user, RealEstate realEstate) {
		return true;
	}

	public void addRealEstate(RealEstateDTO form) {
		RealEstate realEstate = new RealEstate();
		realEstate = initialize(realEstate, form);

		ZonedDateTime zdt = ZonedDateTime.now();
		Date date = Date.from(zdt.toInstant());
		realEstate.setSupplementDate(date);

		// User user =
		// userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		// realEstate.setUser(user);

		addOrUpdate(realEstate);
	}

	public void updateRealEstate(RealEstate realEstate, RealEstateDTO form) {
		realEstate = initialize(realEstate, form);
		addOrUpdate(realEstate);
	}

	private RealEstate initialize(RealEstate realEstate, RealEstateDTO form) {
		realEstate.setLocation(form.getLocation());
		realEstate.setRealEstateType(form.getRealEstateType());
		realEstate.setFloorArea(form.getFloorArea());
		realEstate.setPrice(form.getPrice());
		realEstate.setNumberOfRooms(form.getNumberOfRooms());
		realEstate.setHowOld(form.getHowOld());
		realEstate.setGarage(form.getGarage());
		realEstate.setParking(form.getParking());
		realEstate.setGarden(form.getGarden());
		realEstate.setCellar(form.getCellar());
		realEstate.setFloor(form.getFloor());
		realEstate.setMonitoring(form.getMonitoring());
		realEstate.setLift(form.getLift());
		realEstate.setOwnContribution(form.getOwnContribution());
		realEstate.setKmPerDay(form.getKmPerDay());
		realEstate.setMaintenanceCosts(form.getMaintenanceCosts());
		realEstate.setAccessToPublicTransport(form.getAccessToPublicTransport());
		realEstate.setAveragePriceInArea(form.getAveragePriceInArea());
		realEstate.setAdvertismentsLink(form.getAdvertismentsLink());
		realEstate.setNotes(form.getNotes());
		return realEstate;
	}

}
