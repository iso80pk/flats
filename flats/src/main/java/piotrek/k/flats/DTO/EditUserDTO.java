package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditUserDTO {

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 1, max = 40, message = "Pole mo�e zawiera� od 1 do 40 znak�w")
	private String firstName;

	@Size(min = 1, max = 40, message = "Pole mo�e zawiera� od 1 do 40 znak�w")
	private String lastName;

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 4, max = 35, message = "Pole mo�e zawiera� od 4 do 35 znak�w")
	private String username;

	private boolean enabled;

	@NotEmpty(message = "Pole jest wymagane")
	@Email(message = "Pole piwinno zawiera� prawid�owy adres e-mail")
	@Size(min = 3, max = 60, message = "Pole mo�e zawiera� od 3 do 60 znak�w")
	private String email;

	@Size(max = 13, message = "Pole mo�e zawiera� do 13 znak�w")
	private String phoneNumber;

}
