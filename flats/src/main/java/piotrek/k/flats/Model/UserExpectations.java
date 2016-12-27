package piotrek.k.flats.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userExpectations")
public class UserExpectations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length = 50)
	private String location; //?
	
	@Column(length = 40)
	private String realEstateType;
	
	private Double minFloorArea;
	private Double maxFloorArea;

	private Double minPrice;
	private Double maxPrice;

	private Integer minNumberOfRooms;
	private Integer maxNumberOfRooms;
	
	private Integer minHowOld;
	private Integer maxHowOld;

	private Integer minFloor;
	private Integer MaxFloor;


	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;
	
	
    
	@OneToOne
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
		return MaxFloor;
	}
	public void setMaxFloor(Integer maxFloor) {
		MaxFloor = maxFloor;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

			
}
