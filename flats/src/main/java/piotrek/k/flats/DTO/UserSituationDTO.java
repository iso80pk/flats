package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserSituationDTO {
	
	@NotNull(message="Pole jest wymagane")
	@DecimalMin(value = "0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "150.0", message = "Minimalna wartoœæ to 150")
	private Double nextRemoval;
	
	@NotNull(message="Pole jest wymagane")
	@Min(1)
	@Max(50)
	private Integer numberOfFamilyMembers;
	
	@NotNull(message="Pole jest wymagane")
	@DecimalMin(value = "10.0", message = "Minimalna wartoœæ to 10")
	@DecimalMax(value = "99999999.99", message = "Minimalna wartoœæ to 99999999")
	private Double maxPriceOfRealEstate;
	
	@NotNull(message="Pole jest wymagane")
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "99999999.99", message = "Minimalna wartoœæ to 99999999")
	private Double maxAdditionalCosts; //? utrzymanie+ remonty+.. na jaki okres?
	
	
	@DecimalMin(value = "3.0", message = "Minimalna wartoœæ to 3")
	@DecimalMax(value = "10000.0", message = "Minimalna wartoœæ to 10000.0")
	private Double minAreaRealEstate;
	

	@DecimalMin(value = "3.0", message = "Minimalna wartoœæ to 3")
	@DecimalMax(value = "10000.0", message = "Minimalna wartoœæ to 10000")
	private Double maxAreaRealEstate;
	
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "10000.0", message = "Minimalna wartoœæ to 10000")
	private Double costOfPersonalCarUsage;

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

}
