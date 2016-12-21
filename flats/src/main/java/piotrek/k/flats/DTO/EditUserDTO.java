package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EditUserDTO {

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 1, max = 40, message="Pole mo¿e zawieraæ od 1 do 40 znaków")
	private String firstName;

	@Size(min = 1, max = 40, message="Pole mo¿e zawieraæ od 1 do 40 znaków")
	private String lastName;

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 4, max = 35, message="Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String username;

	private boolean enabled;

	@NotEmpty(message="Pole jest wymagane")
	@Email(message="Pole piwinno zawieraæ prawid³owy adres e-mail")
	@Size(min = 3, max = 60, message="Pole mo¿e zawieraæ od 3 do 60 znaków")
	private String email;

	@Size(max = 13, message="Pole mo¿e zawieraæ do 13 znaków")
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
	
	
}
