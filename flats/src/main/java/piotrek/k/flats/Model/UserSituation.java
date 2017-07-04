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
@Table(name = "userSituation")
public class UserSituation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer nextRemoval;
	private Integer numberOfFamilyMembers;
	private Double costOfPersonalCarUsage;

	@OneToOne
	private User user;

}
