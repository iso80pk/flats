package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpectationsDTO {

	@Size(min = 3, max = 50, message = "Pole mo�e zawiera� od 3 do 50 znak�w")
	private String location;

	@Size(min = 3, max = 35, message = "Pole mo�e zawiera� od 3 do 35 znak�w")
	private String realEstateType;

	@DecimalMin(value = "3.0", message = "Minimalna warto�� to 3")
	private Double minFloorArea;

	@DecimalMin(value = "3.0", message = "Minimalna warto�� to 3")
	private Double maxFloorArea;

	@DecimalMin(value = "100.0", message = "Minimalna warto�� to 100")
	@DecimalMax(value = "99999999.99", message = "Maksymalna warto�� to 99999999.99")
	private Double minPrice;

	@DecimalMin(value = "100.0", message = "Minimalna warto�� to 100")
	@DecimalMax(value = "99999999.99", message = "Maksymalna warto�� to 99999999.99")
	private Double maxPrice;

	@Min(value = 1, message = "Warto�� powinna by� wi�ksza od 0")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer minNumberOfRooms;

	@Min(value = 1, message = "Warto�� powinna by� wi�ksza od 0")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer maxNumberOfRooms;

	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 500, message = "Warto�� powinna wynosi� co najwy�ej 500")
	private Integer minHowOld;

	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 500, message = "Warto�� powinna wynosi� co najwy�ej 500")
	private Integer maxHowOld;

	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer minFloor;

	@Min(value = 0, message = "Warto�� nie mo�e by� ujemna")
	@Max(value = 100, message = "Warto�� powinna wynosi� co najwy�ej 100")
	private Integer maxFloor;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;

}
