package piotrek.k.flats.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "realEstate")
public class RealEstate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long realEstate_id;

	@NotNull
	@Column(length = 50)
	private String location;

	@NotNull
	@Column(length = 35)
	private String realEstateType;

	@NotNull
	private Double floorArea;

	@NotNull
	private Double price;

	@NotNull
	private Integer numberOfRooms;
	private Integer howOld;

	private Boolean garage;
	private Boolean parking;
	private Boolean garden;
	private Boolean cellar;
	private Integer floor;
	private Boolean monitoring;
	private Boolean lift;
	private Boolean accessToPublicTransport;
	private Double averagePriceInArea;
	private String advertismentsLink;
	private String sellerPhoneNumber;
	private Date supplementDate;

	private Boolean active;
	private Boolean availableToOtherUsers;
	private Boolean isUnavailable;

	@ManyToOne(cascade = CascadeType.REMOVE)
	private User supplementBy;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "realEstate", cascade = CascadeType.REMOVE)
	private List<RealEstateUser> realEstateUsers;

}
