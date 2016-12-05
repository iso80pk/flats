package piotrek.k.flats.Model;

import java.util.Date;
import java.util.List;

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

	private boolean enabled;

	@NotNull
	@Column(unique = true, length = 60)
	private String email;

	@Column(length = 15)
	private String phoneNumber;

	private Date signUpDate;

	@LazyCollection(LazyCollectionOption.FALSE) // ?
	@OneToMany(mappedBy = "user")
	private List<Statistics> statistics;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user")
	private List<Roles> roles;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToMany(mappedBy = "user")
	private List<RealEstate> realEstates;

	@LazyCollection(LazyCollectionOption.TRUE)
	@OneToOne(mappedBy = "user")
	private UserSituation userSituation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(Date signUpDate) {
		this.signUpDate = signUpDate;
	}

	public List<Statistics> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<Statistics> statistics) {
		this.statistics = statistics;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public List<RealEstate> getRealEstates() {
		return realEstates;
	}

	public void setRealEstates(List<RealEstate> realEstates) {
		this.realEstates = realEstates;
	}

	public UserSituation getUserSituation() {
		return userSituation;
	}

	public void setUserSituation(UserSituation userSituation) {
		this.userSituation = userSituation;
	}

}
