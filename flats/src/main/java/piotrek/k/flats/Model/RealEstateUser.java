package piotrek.k.flats.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RealEstateUser")
public class RealEstateUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "realEstate_id")
	private RealEstate realEstate;

	private String nammedByUser;

	private Integer rankedPosition;
	private Float adaptation; // dopasowanie
	private Boolean fulfillsAllUserExpectation;
	private Boolean favorite;

	private Double ownContribution;
	private Double kmPerDay;
	private Double maintenanceCosts;

	@Type(type = "text")
	private String notes;

}
