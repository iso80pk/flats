package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserSituationDTO {
	
	@NotNull
	@DecimalMin("0.1")
	@DecimalMax("150.0")
	private Double nextRemoval;
	
	@NotNull
	@Min(1)
	@Max(50)
	private Integer numberOfFamilyMembers;
	
	@NotNull
	@DecimalMin("10.0")
	@DecimalMax("99999999.99")
	private Double maxPriceOfRealEstate;
	
	@NotNull
	@DecimalMin("0.0")
	@DecimalMax("99999999.99")
	private Double maxAdditionalCosts; //? utrzymanie+ remonty+.. na jaki okres?
	
	
	@DecimalMin("3.0")
	@DecimalMax("10000.0")
	private Double minAreaRealEstate;
	

	@DecimalMin("3.0")
	@DecimalMax("10000.0")
	private Double maxAreaRealEstate;
	
	@DecimalMin("0.0")
	@DecimalMax("10000.0")
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
