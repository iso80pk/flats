package piotrek.k.flats.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "realEstate")
public class RealEstate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String location;
	private String realEstateType;
	private Double floorArea;
	private Double price;
	private Integer numberOfRooms;
	private Integer howOld;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Integer floor;
	private Boolean monitoring;
	private Boolean lift;
	private Double ownContribution;
	private Double kmPerDay;
	private Double maintenanceCosts;
	private Boolean accessToPublicTransport;
	private Double averagePriceInArea;
	private String advertismentsLink;
	@Type(type="text")
	private String notes;

	private Date supplementDate;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getSupplementDate() {
		return supplementDate;
	}

	public void setSupplementDate(Date supplementDate) {
		this.supplementDate = supplementDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
