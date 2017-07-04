package piotrek.k.flats.DTO;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportanceOfExpectationsDTO {

	@Min(0)
	@Max(10)
	private Integer location;

	@Min(0)
	@Max(10)
	private Integer realEstateType;

	@Min(0)
	@Max(10)
	private Integer floorArea;

	@Min(0)
	@Max(10)
	private Integer price;

	@Min(0)
	@Max(10)
	private Integer numberOfRooms;

	@Min(0)
	@Max(10)
	private Integer howOld;

	@Min(0)
	@Max(10)
	private Integer floor;

	@Min(0)
	@Max(10)
	private Integer garage;

	@Min(0)
	@Max(10)
	private Integer parking;

	@Min(0)
	@Max(10)
	private Integer garden;

	@Min(0)
	@Max(10)
	private Integer cellar;

	@Min(0)
	@Max(10)
	private Integer monitoring;

	@Min(0)
	@Max(10)
	private Integer lift;

	@Min(0)
	@Max(10)
	private Integer accessToPublicTransport;

}
