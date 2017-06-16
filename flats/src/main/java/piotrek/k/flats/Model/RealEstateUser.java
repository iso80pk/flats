package piotrek.k.flats.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "RealEstateUser")
public class RealEstateUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "realEstate_id")
	private RealEstate realEstate;

	private String nammedByUser;

	private Integer rankedPosition;
	private Float adaptation; // dopasowanie
	private Boolean fulfillsAllUserExpectation;
	private Boolean favorite;

	private Double ownContribution;
	private Double kmPerDay;
	private Double maintenanceCosts;
	@Type(type = "text")
	private String notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public RealEstate getRealEstate() {
		return realEstate;
	}
	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}
	public String getNammedByUser() {
		return nammedByUser;
	}
	public void setNammedByUser(String nammedByUser) {
		this.nammedByUser = nammedByUser;
	}
	public Integer getRankedPosition() {
		return rankedPosition;
	}
	public void setRankedPosition(Integer rankedPosition) {
		this.rankedPosition = rankedPosition;
	}
	public Float getAdaptation() {
		return adaptation;
	}
	public void setAdaptation(Float adaptation) {
		this.adaptation = adaptation;
	}
	public Boolean getFulfillsAllUserExpectation() {
		return fulfillsAllUserExpectation;
	}
	public void setFulfillsAllUserExpectation(Boolean fulfillsAllUserExpectation) {
		this.fulfillsAllUserExpectation = fulfillsAllUserExpectation;
	}
	public Boolean getFavorite() {
		return favorite;
	}
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
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
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
}
