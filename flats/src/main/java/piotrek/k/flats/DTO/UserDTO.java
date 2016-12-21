package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserDTO {

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 1, max = 40, message="Pole mo�e zawiera� od 1 do 40 znak�w")
	private String firstName;

	@Size(min = 1, max = 40, message="Pole mo�e zawiera� od 1 do 40 znak�w")
	private String lastName;

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 4, max = 35, message="Pole mo�e zawiera� od 4 do 35 znak�w")
	private String username;

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 4, max = 35, message="Pole mo�e zawiera� od 4 do 35 znak�w")
	private String password;

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 4, max = 35, message="Pole mo�e zawiera� od 4 do 35 znak�w")
	private String repeatPassword;

	@NotEmpty(message="Pole jest wymagane")
	@Email(message="Pole piwinno zawiera� prawid�owy adres e-mail")
	@Size(min = 3, max = 60, message="Pole mo�e zawiera� od 3 do 60 znak�w")
	private String email;

	@NotEmpty(message="Pole jest wymagane")
	@Email(message="Pole piwinno zawiera� prawid�owy adres e-mail")
	@Size(min = 3, max = 60, message="Pole mo�e zawiera� od 3 do 60 znak�w")
	private String repeatEmail;

	@Size(max = 13, message="Pole mo�e zawiera� do 13 znak�w")
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
