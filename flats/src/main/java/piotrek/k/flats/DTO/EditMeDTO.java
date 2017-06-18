package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditMeDTO {

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 1, max = 40, message = "Pole mo�e zawiera� od 1 do 40 znak�w")
	private String firstName;

	@Size(max = 40, message = "Pole mo�e zawiera� do 40 znak�w")
	private String lastName;

	@Size(max = 13, message = "Pole mo�e zawiera� do 13 znak�w")
	private String phoneNumber;

}
