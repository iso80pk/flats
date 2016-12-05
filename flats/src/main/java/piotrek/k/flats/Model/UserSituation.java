package piotrek.k.flats.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userSituation")
public class UserSituation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double nextRemoval;
	private Integer numberOfFamilyMembers;
	private Double maxPriceOfRealEstate;
	private Double maxAdditionalCosts; //? utrzymanie+ remonty+.. na jaki okres?
	private Double minAreaRealEstate;
	private Double maxAreaRealEstate;
	private Double costOfPersonalCarUsage;
	private Date supplementDate;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getNextRemoval() {
		return nextRemoval;
	}

	public void setNextRemoval(Double nextRemoval) {
		this.nextRemoval = nextRemoval;
	}

	public Integer getNumberOfFamilyMembers() {
		return numberOfFamilyMembers;
	}

	public void setNumberOfFamilyMembers(Integer numberOfFamilyMembers) {
		this.numberOfFamilyMembers = numberOfFamilyMembers;
	}

	public Double getMaxPriceOfRealEstate() {
		return maxPriceOfRealEstate;
	}

	public void setMaxPriceOfRealEstate(Double maxPriceOfRealEstate) {
		this.maxPriceOfRealEstate = maxPriceOfRealEstate;
	}

	public Double getMaxAdditionalCosts() {
		return maxAdditionalCosts;
	}

	public void setMaxAdditionalCosts(Double maxAdditionalCosts) {
		this.maxAdditionalCosts = maxAdditionalCosts;
	}

	public Double getMinAreaRealEstate() {
		return minAreaRealEstate;
	}

	public void setMinAreaRealEstate(Double minAreaRealEstate) {
		this.minAreaRealEstate = minAreaRealEstate;
	}

	public Double getMaxAreaRealEstate() {
		return maxAreaRealEstate;
	}

	public void setMaxAreaRealEstate(Double maxAreaRealEstate) {
		this.maxAreaRealEstate = maxAreaRealEstate;
	}

	public Double getCostOfPersonalCarUsage() {
		return costOfPersonalCarUsage;
	}

	public void setCostOfPersonalCarUsage(Double costOfPersonalCarUsage) {
		this.costOfPersonalCarUsage = costOfPersonalCarUsage;
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
