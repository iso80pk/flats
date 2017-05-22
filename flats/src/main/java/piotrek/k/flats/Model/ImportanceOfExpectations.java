package piotrek.k.flats.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "importanceOfExpectations")
public class ImportanceOfExpectations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer location;
	private Integer realEstateType;
	private Integer floorArea;
	private Integer price;
	private Integer numberOfRooms;
	private Integer howOld;
	private Integer floor;
	private Integer garage;
	private Integer parking;
	private Integer garden;
	private Integer cellar;
	private Integer monitoring;
	private Integer lift;
	private Integer accessToPublicTransport;
	
	private Integer location_priority;
	private Integer realEstateType_priority;
	private Integer floorArea_priority;
	private Integer price_priority;
	private Integer numberOfRooms_priority;
	private Integer howOld_priority;
	private Integer floor_priority;
	private Integer garage_priority;
	private Integer parking_priority;
	private Integer garden_priority;
	private Integer cellar_priority;
	private Integer monitoring_priority;
	private Integer lift_priority;
	private Integer accessToPublicTransport_priority;

	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Integer getRealEstateType() {
		return realEstateType;
	}

	public void setRealEstateType(Integer realEstateType) {
		this.realEstateType = realEstateType;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public Integer getHowOld() {
		return howOld;
	}

	public void setHowOld(Integer howOld) {
		this.howOld = howOld;
	}

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getGarage() {
		return garage;
	}

	public void setGarage(Integer garage) {
		this.garage = garage;
	}

	public Integer getParking() {
		return parking;
	}

	public void setParking(Integer parking) {
		this.parking = parking;
	}

	public Integer getGarden() {
		return garden;
	}

	public void setGarden(Integer garden) {
		this.garden = garden;
	}

	public Integer getCellar() {
		return cellar;
	}

	public void setCellar(Integer cellar) {
		this.cellar = cellar;
	}

	public Integer getMonitoring() {
		return monitoring;
	}

	public void setMonitoring(Integer monitoring) {
		this.monitoring = monitoring;
	}

	public Integer getLift() {
		return lift;
	}

	public void setLift(Integer lift) {
		this.lift = lift;
	}

	public Integer getAccessToPublicTransport() {
		return accessToPublicTransport;
	}

	public void setAccessToPublicTransport(Integer accessToPublicTransport) {
		this.accessToPublicTransport = accessToPublicTransport;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getLocation_priority() {
		return location_priority;
	}

	public void setLocation_priority(Integer location_priority) {
		this.location_priority = location_priority;
	}

	public Integer getRealEstateType_priority() {
		return realEstateType_priority;
	}

	public void setRealEstateType_priority(Integer realEstateType_priority) {
		this.realEstateType_priority = realEstateType_priority;
	}

	public Integer getFloorArea_priority() {
		return floorArea_priority;
	}

	public void setFloorArea_priority(Integer floorArea_priority) {
		this.floorArea_priority = floorArea_priority;
	}

	public Integer getPrice_priority() {
		return price_priority;
	}

	public void setPrice_priority(Integer price_priority) {
		this.price_priority = price_priority;
	}

	public Integer getNumberOfRooms_priority() {
		return numberOfRooms_priority;
	}

	public void setNumberOfRooms_priority(Integer numberOfRooms_priority) {
		this.numberOfRooms_priority = numberOfRooms_priority;
	}

	public Integer getHowOld_priority() {
		return howOld_priority;
	}

	public void setHowOld_priority(Integer howOld_priority) {
		this.howOld_priority = howOld_priority;
	}

	public Integer getFloor_priority() {
		return floor_priority;
	}

	public void setFloor_priority(Integer floor_priority) {
		this.floor_priority = floor_priority;
	}

	public Integer getGarage_priority() {
		return garage_priority;
	}

	public void setGarage_priority(Integer garage_priority) {
		this.garage_priority = garage_priority;
	}

	public Integer getParking_priority() {
		return parking_priority;
	}

	public void setParking_priority(Integer parking_priority) {
		this.parking_priority = parking_priority;
	}

	public Integer getGarden_priority() {
		return garden_priority;
	}

	public void setGarden_priority(Integer garden_priority) {
		this.garden_priority = garden_priority;
	}

	public Integer getCellar_priority() {
		return cellar_priority;
	}

	public void setCellar_priority(Integer cellar_priority) {
		this.cellar_priority = cellar_priority;
	}

	public Integer getMonitoring_priority() {
		return monitoring_priority;
	}

	public void setMonitoring_priority(Integer monitoring_priority) {
		this.monitoring_priority = monitoring_priority;
	}

	public Integer getLift_priority() {
		return lift_priority;
	}

	public void setLift_priority(Integer lift_priority) {
		this.lift_priority = lift_priority;
	}

	public Integer getAccessToPublicTransport_priority() {
		return accessToPublicTransport_priority;
	}

	public void setAccessToPublicTransport_priority(Integer accessToPublicTransport_priority) {
		this.accessToPublicTransport_priority = accessToPublicTransport_priority;
	}
	
	

}
