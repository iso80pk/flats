package piotrek.k.flats.Service;

import java.time.ZonedDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DTO.RealEstateDTO;
import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.User;
import piotrek.k.flats.Repository.IRealEstateInterface;

@Service
public class RealEstateService extends BaseService<IRealEstateInterface, RealEstate> {

	@Autowired
	UserService userService;

	public boolean itIsMyRealEstate(User user, RealEstate realEstate) {
		return true;
	}

	public void addRealEstate(RealEstateDTO form) {
		RealEstate realEstate = new RealEstate();
		realEstate = initialize(realEstate, form);

		ZonedDateTime zdt = ZonedDateTime.now();
		Date date = Date.from(zdt.toInstant());
		realEstate.setSupplementDate(date);

		User user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		realEstate.setSupplementBy(user);
		realEstate.setActive(true);
		realEstate.setIsUnavailable(false);

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
		// realEstate.setOwnContribution(form.getOwnContribution());
		// realEstate.setKmPerDay(form.getKmPerDay());
		// realEstate.setMaintenanceCosts(form.getMaintenanceCosts());
		realEstate.setAccessToPublicTransport(form.getAccessToPublicTransport());
		realEstate.setAveragePriceInArea(form.getAveragePriceInArea());
		realEstate.setAdvertismentsLink(form.getAdvertismentsLink());
		// realEstate.setNotes(form.getNotes());
		realEstate.setSellerPhoneNumber(form.getSellerPhoneNumber());
		realEstate.setActive(form.getActive());
		realEstate.setAvailableToOtherUsers(form.getAvailableToOtherUsers());
		return realEstate;
	}

	public RealEstate searchDataInContentOfAdvertisement(String text) {
		String advertisementText = text.toLowerCase().trim();
		RealEstate realEstate = new RealEstate();
		realEstate.setPrice((double) tryFindIntegerValue(advertisementText, "cen"));
		realEstate.setFloorArea(tryFindDoubleValue(advertisementText, "powierzch"));
		realEstate.setNumberOfRooms(tryFindIntegerValue(advertisementText, "poko"));
		realEstate.setFloor(tryFindIntegerValue(advertisementText, "piêtr"));
		realEstate.setGarage(isWord(advertisementText, "gara¿"));
		realEstate.setParking(isWord(advertisementText, "parking"));
		realEstate.setGarden(isWord(advertisementText, "ogró"));
		realEstate.setCellar(isWord(advertisementText, "piwni"));
		realEstate.setMonitoring(isWord(advertisementText, "monitoring"));
		realEstate.setLift(isWord(advertisementText, "wind"));
		realEstate.setRealEstateType(isHomeOrFlat(advertisementText));
		// realEstate.setSellerPhoneNumber();
		// realEstate.setLocation(location);
		// realEstate.setHowOld(howOld);
		// realEstate.setAccessToPublicTransport(accessToPublicTransport);

		return realEstate;
	}

	private Integer tryFindIntegerValue(String advertisementText, String searchingText) {
		if (advertisementText.contains(searchingText)) {
			String substring = advertisementText.substring(advertisementText.indexOf(searchingText),
					advertisementText.length());

			if (substring.length() > 31) {
				substring = substring.substring(0, 30);
			}
			Matcher matcher = Pattern.compile("(\\d)+((,| |\\.)(\\d)+)?").matcher(substring);
			matcher.find();
			try {
				return Integer.parseInt(matcher.group().replaceAll("(,| |\\.)", ""));
			} catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	private Double tryFindDoubleValue(String advertisementText, String searchingText) {
		if (advertisementText.contains(searchingText)) {
			String substring = advertisementText.substring(advertisementText.indexOf(searchingText),
					advertisementText.length());
			if (substring.length() > 31) {
				substring = substring.substring(0, 30);
			}
			Matcher matcher = Pattern.compile("(\\d)+((,|\\.)(\\d{0,2}))?").matcher(substring);
			matcher.find();
			try {
				return Double.parseDouble(matcher.group().replaceAll(",", "."));
			} catch (Exception e) {

				System.out.println(e.getMessage());
				return null;
			}
		}
		return null;
	}

	private Boolean isWord(String advertisementText, String searchingText) {
		if (advertisementText.contains(searchingText)) {
			return true;
		}
		return null;
	}

	private String isHomeOrFlat(String advertisementText) {
		Boolean result = isWord(advertisementText, "dom ");
		if (result != null)
			return "DOM";
		return "MIESZKANIE";
	}

}
