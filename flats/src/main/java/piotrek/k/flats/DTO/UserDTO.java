package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty
	@Size(min = 1, max = 40)
	private String firstName;

	@Size(max = 40)
	private String lastName;

	@NotEmpty
	@Size(min = 4, max = 35)
	private String username;

	@NotEmpty
	@Size(min = 4, max = 60)
	private String password;

	@NotEmpty
	@Size(min = 4, max = 60)
	private String repeatPassword;

	@NotEmpty
	@Size(min = 3, max = 60)
	private String email;

	@NotEmpty
	@Size(min = 3, max = 60)
	private String repeatEmail;

	@Size(max = 15)
	private String phoneNumber;

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

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRepeatEmail() {
		return repeatEmail;
	}

	public void setRepeatEmail(String repeatEmail) {
		this.repeatEmail = repeatEmail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
