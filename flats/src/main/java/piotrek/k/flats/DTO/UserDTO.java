package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 1, max = 40, message = "Pole mo¿e zawieraæ od 1 do 40 znaków")
	private String firstName;

	@Size(min = 0, max = 40, message = "Pole mo¿e zawieraæ od 1 do 40 znaków")
	private String lastName;

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 4, max = 35, message = "Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String username;

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 4, max = 35, message = "Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String password;

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 4, max = 35, message = "Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String repeatPassword;

	@NotEmpty(message = "Pole jest wymagane")
	@Email(message = "Pole piwinno zawieraæ prawid³owy adres e-mail")
	@Size(min = 3, max = 60, message = "Pole mo¿e zawieraæ od 3 do 60 znaków")
	private String email;

	@NotEmpty(message = "Pole jest wymagane")
	@Email(message = "Pole piwinno zawieraæ prawid³owy adres e-mail")
	@Size(min = 3, max = 60, message = "Pole mo¿e zawieraæ od 3 do 60 znaków")
	private String repeatEmail;

	@Size(max = 13, message = "Pole mo¿e zawieraæ do 13 znaków")
	private String phoneNumber;

}
