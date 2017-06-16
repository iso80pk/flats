package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RealEstateDTO {

	private Long id;
	@NotNull(message = "Pole jest wymagane")
	@Size(min = 3, max = 50, message = "Pole mo¿e zawieraæ od 3 do 50 znaków")
	private String location;

	@NotNull(message = "Pole jest wymagane")
	@Size(min = 3, max = 35, message = "Pole mo¿e zawieraæ od 3 do 35 znaków")
	private String realEstateType;

	@NotNull(message = "Pole jest wymagane")
	@DecimalMin(value = "3.0", message = "Minimalna wartoœæ to 3")
	private Double floorArea;

	@NotNull(message = "Pole jest wymagane")
	@DecimalMin(value = "100.0", message = "Minimalna wartoœæ to 100")
	@DecimalMax(value = "99999999.99", message = "Maksymalna wartoœæ to 99999999.99")
	private Double price;

	@NotNull(message = "Pole jest wymagane")
	@Min(value = 1, message = "Wartoœæ powinna byæ wiêksza od 0")
	@Max(value = 100, message = "Wartoœæ powinna wynosiæ co najwy¿ej 100")
	private Integer numberOfRooms;

	@Min(value = 0, message = "Wartoœæ nie mo¿e byæ ujemna")
	@Max(value = 500, message = "Wartoœæ powinna wynosiæ co najwy¿ej 500")
	@NotNull(message = "Pole jest wymagane")
	private Integer howOld;

	@Min(value = 0, message = "Wartoœæ nie mo¿e byæ ujemna")
	@Max(value = 100, message = "Wartoœæ powinna wynosiæ co najwy¿ej 100")
	private Integer floor;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;

	@DecimalMin(value = "100.0", message = "Minimalna wartoœæ to 100")
	@DecimalMax(value = "999999.99", message = "Maksymalna wartoœæ to 999999.99")
	private Double averagePriceInArea;

	private String advertismentsLink;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

}
