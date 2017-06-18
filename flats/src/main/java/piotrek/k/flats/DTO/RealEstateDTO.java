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
	@Size(min = 3, max = 50, message = "Pole mo�e zawiera� od 3 do 50 znak�w")
	private String location;

	@NotNull(message = "Pole jest wymagane")
	@Size(min = 3, max = 35, message = "Pole mo�e zawiera� od 3 do 35 znak�w")
	private String realEstateType;

	@NotNull(message = "Pole jest wymagane")
	@DecimalMin(value = "3.0", message = "Minimalna warto�� to 3")
	private Double floorArea;

	@NotNull(message = "Pole jest wymagane")
	@DecimalMin(value = "100.0", message = "Minimalna warto�� to 100")
	@DecimalMax(value = "99999999.99", message = "Maksymalna warto�� to 99999999.99")
	private Double price;

	@NotNull(message = "Pole jest wymagane")
	@Min(value = 1, message = "Warto�� powinna by� wi�ksza od 0")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer numberOfRooms;

	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 500, message = "Warto�� powinna wynosi� co najwy�ej 500")
	@NotNull(message = "Pole jest wymagane")
	private Integer howOld;

	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer floor;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;

	@DecimalMin(value = "100.0", message = "Minimalna warto�� to 100")
	@DecimalMax(value = "999999.99", message = "Maksymalna warto�� to 999999.99")
	private Double averagePriceInArea;

	private String advertismentsLink;

}
