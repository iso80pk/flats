package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealEstateUserDTO {

	private RealEstateDTO realEstateDTO;

	private String nammedByUser;
	private Integer rankedPosition;
	private Float adaptation; // dopasowanie
	private Boolean fulfillsAllUserExpectation;
	private Boolean favorite;
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "99999999.99", message = "Maksymalna wartoœæ to 99999999.99")
	private Double ownContribution;
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "9999.99", message = "Maksymalna wartoœæ to 9999.99")
	private Double kmPerDay;
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "99999.99", message = "Maksymalna wartoœæ to 99999.99")
	private Double maintenanceCosts;
	private String notes;

}
