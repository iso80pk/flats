package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UserSituationDTO {
	
	@NotNull(message="Pole jest wymagane")
	@Min(1)
	@Max(100)
	private Integer nextRemoval;
	
	@NotNull(message="Pole jest wymagane")
	@Min(1)
	@Max(50)
	private Integer numberOfFamilyMembers;
	
	@NotNull(message="Pole jest wymagane")			
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "500.0", message = "Minimalna wartoœæ to 500")
	private Double costOfPersonalCarUsage;

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

	
	
}
