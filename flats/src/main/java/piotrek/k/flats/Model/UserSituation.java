package piotrek.k.flats.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userSituation")
public class UserSituation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer nextRemoval;
	private Integer numberOfFamilyMembers;
	private Double costOfPersonalCarUsage;
	
	@OneToOne
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNextRemoval() {
		return nextRemoval;
	}

	public void setNextRemoval(Integer nextRemoval) {
		this.nextRemoval = nextRemoval;
	}

	public Integer getNumberOfFamilyMembers() {
		return numberOfFamilyMembers;
	}

	public void setNumberOfFamilyMembers(Integer numberOfFamilyMembers) {
		this.numberOfFamilyMembers = numberOfFamilyMembers;
	}

	public Double getCostOfPersonalCarUsage() {
		return costOfPersonalCarUsage;
	}

	public void setCostOfPersonalCarUsage(Double costOfPersonalCarUsage) {
		this.costOfPersonalCarUsage = costOfPersonalCarUsage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
