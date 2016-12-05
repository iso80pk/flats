package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RealEstateDTO {

	@NotNull
	@Size(min = 3, max = 50)
	private String location;

	@NotNull
	@Size(min = 3, max = 35)
	private String realEstateType;

	@NotNull
	@DecimalMin("3.0")
	private Double floorArea;

	@NotNull
	@DecimalMin("10.0")
	@DecimalMax("99999999.99")
	private Double price;

	@NotNull
	@Min(0)
	@Max(50)
	private Integer numberOfRooms;

	@Min(0)
	@Max(500)
	@NotNull
	private Integer howOld;
	
	@Min(0)
	@Max(50)
	private Integer floor;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;

	@DecimalMin("0.0")
	@DecimalMax("99999999.99")
	private Double ownContribution;
	@DecimalMin("0.0")
	@DecimalMax("9999.99")
	private Double kmPerDay;
	@DecimalMin("0.0")
	@DecimalMax("99999.99")
	private Double maintenanceCosts;

	@DecimalMin("100.0")
	@DecimalMax("999999.99")
	private Double averagePriceInArea;
	private String advertismentsLink;
	private String notes;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRealEstateType() {
		return realEstateType;
	}
	public void setRealEstateType(String realEstateType) {
		this.realEstateType = realEstateType;
	}
	public Double getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Double floorArea) {
		this.floorArea = floorArea;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
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
	public Boolean getGarage() {
		return garage;
	}
	public void setGarage(Boolean garage) {
		this.garage = garage;
	}
	public Boolean getParking() {
		return parking;
	}
	public void setParking(Boolean parking) {
		this.parking = parking;
	}
	public Boolean getGarden() {
		return garden;
	}
	public void setGarden(Boolean garden) {
		this.garden = garden;
	}
	public Boolean getCellar() {
		return cellar;
	}
	public void setCellar(Boolean cellar) {
		this.cellar = cellar;
	}
	public Boolean getMonitoring() {
		return monitoring;
	}
	public void setMonitoring(Boolean monitoring) {
		this.monitoring = monitoring;
	}
	public Boolean getLift() {
		return lift;
	}
	public void setLift(Boolean lift) {
		this.lift = lift;
	}
	public Boolean getAccessToPublicTransport() {
		return accessToPublicTransport;
	}
	public void setAccessToPublicTransport(Boolean accessToPublicTransport) {
		this.accessToPublicTransport = accessToPublicTransport;
	}
	public Double getOwnContribution() {
		return ownContribution;
	}
	public void setOwnContribution(Double ownContribution) {
		this.ownContribution = ownContribution;
	}
	public Double getKmPerDay() {
		return kmPerDay;
	}
	public void setKmPerDay(Double kmPerDay) {
		this.kmPerDay = kmPerDay;
	}
	public Double getMaintenanceCosts() {
		return maintenanceCosts;
	}
	public void setMaintenanceCosts(Double maintenanceCosts) {
		this.maintenanceCosts = maintenanceCosts;
	}
	public Double getAveragePriceInArea() {
		return averagePriceInArea;
	}
	public void setAveragePriceInArea(Double averagePriceInArea) {
		this.averagePriceInArea = averagePriceInArea;
	}
	public String getAdvertismentsLink() {
		return advertismentsLink;
	}
	public void setAdvertismentsLink(String advertismentsLink) {
		this.advertismentsLink = advertismentsLink;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}


	
	
}
