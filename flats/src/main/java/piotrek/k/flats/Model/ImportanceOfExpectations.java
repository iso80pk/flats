package piotrek.k.flats.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "importanceOfExpectations")
public class ImportanceOfExpectations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer location;
	private Integer realEstateType;
	private Integer floorArea;
	private Integer price;
	private Integer numberOfRooms;
	private Integer howOld;
	private Integer floor;
	private Integer garage;
	private Integer parking;
	private Integer garden;
	private Integer cellar;
	private Integer monitoring;
	private Integer lift;
	private Integer accessToPublicTransport;

	private Integer location_priority;
	private Integer realEstateType_priority;
	private Integer floorArea_priority;
	private Integer price_priority;
	private Integer numberOfRooms_priority;
	private Integer howOld_priority;
	private Integer floor_priority;
	private Integer garage_priority;
	private Integer parking_priority;
	private Integer garden_priority;
	private Integer cellar_priority;
	private Integer monitoring_priority;
	private Integer lift_priority;
	private Integer accessToPublicTransport_priority;

	@OneToOne
	private User user;
}
