package piotrek.k.flats.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ImportanceOfExpectationsDTO {

	@Min(1)
	@Max(10)
	private Integer location;
	@Min(1)
	@Max(10)
	private Integer realEstateType;
	@Min(1)
	@Max(10)
	private Integer floorArea;
	@Min(1)
	@Max(10)
	private Integer price;
	@Min(1)
	@Max(10)
	private Integer numberOfRooms;
	@Min(1)
	@Max(10)
	private Integer howOld;
	@Min(1)
	@Max(10)
	private Integer floor;
	@Min(1)
	@Max(10)
	private Integer garage;
	@Min(1)
	@Max(10)
	private Integer parking;
	@Min(1)
	@Max(10)
	private Integer garden;
	@Min(1)
	@Max(10)
	private Integer cellar;
	@Min(1)
	@Max(10)
	private Integer monitoring;
	@Min(1)
	@Max(10)
	private Integer lift;
	@Min(1)
	@Max(10)
	private Integer accessToPublicTransport;
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
	
	
}
