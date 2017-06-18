package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
