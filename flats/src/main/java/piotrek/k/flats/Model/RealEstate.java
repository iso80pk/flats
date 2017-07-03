package piotrek.k.flats.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "realEstate")
public class RealEstate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long realEstate_id;

	@NotNull
	@Column(length = 50)
	private String location;

	@NotNull
	@Column(length = 35)
	private String realEstateType;

	@NotNull
	private Double floorArea;

	@NotNull
	private Double price;

	@NotNull
	private Integer numberOfRooms;
	private Integer howOld;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Integer floor;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;
	private Double averagePriceInArea;
	private String advertismentsLink;
	private String sellerPhoneNumber;
	private Date supplementDate;
	
	private Boolean active;
	private Boolean availableToOtherUsers;
	private Boolean isUnavailable;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User supplementBy;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "realEstate", cascade = CascadeType.REMOVE)
	private List<RealEstateUser> realEstateUsers;

	public Long getRealEstate_id() {
		return realEstate_id;
	}

	public void setRealEstate_id(Long realEstate_id) {
		this.realEstate_id = realEstate_id;
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

	public Date getSupplementDate() {
		return supplementDate;
	}

	public void setSupplementDate(Date supplementDate) {
		this.supplementDate = supplementDate;
	}

	public List<RealEstateUser> getRealEstateUsers() {
		return realEstateUsers;
	}

	public void setRealEstateUsers(List<RealEstateUser> realEstateUsers) {
		this.realEstateUsers = realEstateUsers;
	}

	public User getSupplementBy() {
		return supplementBy;
	}

	public void setSupplementBy(User supplementBy) {
		this.supplementBy = supplementBy;
	}

	
}
