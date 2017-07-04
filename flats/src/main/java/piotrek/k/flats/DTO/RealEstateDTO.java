package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealEstateDTO {

	private Long id;
	@NotNull(message = "Pole jest wymagane")
	@Size(min = 3, max = 50, message = "Pole mo¿e zawieraæ od 3 do 50 znaków")
	private String location;

	@NotNull(message = "Pole jest wymagane")
	@Size(min = 3, max = 35, message = "Pole mo¿e zawieraæ od 3 do 35 znaków")
	private String realEstateType;

	@NotNull(message = "Pole jest wymagane")
	@DecimalMin(value = "3.0", message = "Minimalna wartoœæ to 3")
	private Double floorArea;

	@NotNull(message = "Pole jest wymagane")
	@DecimalMin(value = "100.0", message = "Minimalna wartoœæ to 100")
	@DecimalMax(value = "99999999.99", message = "Maksymalna wartoœæ to 99999999.99")
	private Double price;

	@NotNull(message = "Pole jest wymagane")
	@Min(value = 1, message = "Wartoœæ powinna byæ wiêksza od 0")
	@Max(value = 100, message = "Wartoœæ powinna wynosiæ co najwy¿ej 100")
	private Integer numberOfRooms;

	@Min(value = 0, message = "Wartoœæ nie mo¿e byæ ujemna")
	@Max(value = 500, message = "Wartoœæ powinna wynosiæ co najwy¿ej 500")
	@NotNull(message = "Pole jest wymagane")
	private Integer howOld;

	@Min(value = 0, message = "Wartoœæ nie mo¿e byæ ujemna")
	@Max(value = 100, message = "Wartoœæ powinna wynosiæ co najwy¿ej 100")
	private Integer floor;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;

	@DecimalMin(value = "100.0", message = "Minimalna wartoœæ to 100")
	@DecimalMax(value = "999999.99", message = "Maksymalna wartoœæ to 999999.99")
	private Double averagePriceInArea;

	private String advertismentsLink;

}
