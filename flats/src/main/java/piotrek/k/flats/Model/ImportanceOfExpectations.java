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

}
