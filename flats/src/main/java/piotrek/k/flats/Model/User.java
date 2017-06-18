package piotrek.k.flats.Model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(length = 40)
	private String firstName;

	@Column(length = 40)
	private String lastName;

	@NotNull
	@Column(unique = true, length = 35)
	private String username;

	@NotNull
	@Column(length = 60)
	private String password;

	@Column
	private boolean enabled;

	@NotNull
	@Column(unique = true, length = 60)
	private String email;

	@Column(length = 15)
	private String phoneNumber;

	private Date signUpDate;

	private Date lastLoggedInDate;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Roles> roles;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<RealEstateUser> realEstateUsers;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
	private UserSituation userSituation;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
	private UserExpectations userExpectations;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
	private ImportanceOfExpectations importanceOfExpectations;

}
