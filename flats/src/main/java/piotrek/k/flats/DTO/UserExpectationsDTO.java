package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class UserExpectationsDTO {

	
	@Size(min = 3, max = 50, message="Pole mo�e zawiera� od 3 do 50 znak�w")
	private String location;

	
	@Size(min = 3, max = 35, message="Pole mo�e zawiera� od 3 do 35 znak�w")
	private String realEstateType;

	
	@DecimalMin(value = "3.0", message = "Minimalna warto�� to 3")
	private Double minFloorArea;
	
	
	@DecimalMin(value = "3.0", message = "Minimalna warto�� to 3")
	private Double maxFloorArea;
	

	
	@DecimalMin(value = "100.0", message = "Minimalna warto�� to 100")
	@DecimalMax(value = "99999999.99", message = "Maksymalna warto�� to 99999999.99")
	private Double minPrice;

	
	@DecimalMin(value = "100.0", message = "Minimalna warto�� to 100")
	@DecimalMax(value = "99999999.99", message = "Maksymalna warto�� to 99999999.99")
	private Double maxPrice;
	
	
	
	@Min(value = 1, message = "Warto�� powinna by� wi�ksza od 0")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer minNumberOfRooms;
	
	
	@Min(value = 1, message = "Warto�� powinna by� wi�ksza od 0")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer maxNumberOfRooms;
	

	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 500, message = "Warto�� powinna wynosi� co najwy�ej 500")
	private Integer minHowOld;
	
	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 500, message = "Warto�� powinna wynosi� co najwy�ej 500")
	private Integer maxHowOld;
	
	
	
	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer minFloor;
	
	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer maxFloor;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;
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
	public Double getMinFloorArea() {
		return minFloorArea;
	}
	public void setMinFloorArea(Double minFloorArea) {
		this.minFloorArea = minFloorArea;
	}
	public Double getMaxFloorArea() {
		return maxFloorArea;
	}
	public void setMaxFloorArea(Double maxFloorArea) {
		this.maxFloorArea = maxFloorArea;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getMinNumberOfRooms() {
		return minNumberOfRooms;
	}
	public void setMinNumberOfRooms(Integer minNumberOfRooms) {
		this.minNumberOfRooms = minNumberOfRooms;
	}
	public Integer getMaxNumberOfRooms() {
		return maxNumberOfRooms;
	}
	public void setMaxNumberOfRooms(Integer maxNumberOfRooms) {
		this.maxNumberOfRooms = maxNumberOfRooms;
	}
	public Integer getMinHowOld() {
		return minHowOld;
	}
	public void setMinHowOld(Integer minHowOld) {
		this.minHowOld = minHowOld;
	}
	public Integer getMaxHowOld() {
		return maxHowOld;
	}
	public void setMaxHowOld(Integer maxHowOld) {
		this.maxHowOld = maxHowOld;
	}
	public Integer getMinFloor() {
		return minFloor;
	}
	public void setMinFloor(Integer minFloor) {
		this.minFloor = minFloor;
	}
	public Integer getMaxFloor() {
		return maxFloor;
	}
	public void setMaxFloor(Integer maxFloor) {
		this.maxFloor = maxFloor;
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

		
}
