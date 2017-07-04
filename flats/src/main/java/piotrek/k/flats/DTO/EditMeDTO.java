package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditMeDTO {

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 1, max = 40, message = "Pole mo¿e zawieraæ od 1 do 40 znaków")
	private String firstName;

	@Size(max = 40, message = "Pole mo¿e zawieraæ do 40 znaków")
	private String lastName;

	@Size(max = 13, message = "Pole mo¿e zawieraæ do 13 znaków")
	private String phoneNumber;

}
