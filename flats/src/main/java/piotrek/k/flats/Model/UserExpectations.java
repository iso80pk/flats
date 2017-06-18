package piotrek.k.flats.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "userExpectations")
public class UserExpectations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String location; // ?

	@Column(length = 40)
	private String realEstateType;

	private Double minFloorArea;
	private Double maxFloorArea;

	private Double minPrice;
	private Double maxPrice;

	private Integer minNumberOfRooms;
	private Integer maxNumberOfRooms;

	private Integer minHowOld;
	private Integer maxHowOld;

	private Integer minFloor;
	private Integer MaxFloor;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

}
