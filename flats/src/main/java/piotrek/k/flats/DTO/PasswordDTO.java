package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDTO {

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 4, max = 35, message = "Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String oldPassword;

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 4, max = 35, message = "Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String newPassword;

	@NotEmpty(message = "Pole jest wymagane")
	@Size(min = 4, max = 35, message = "Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String repetedNewPassword;

}
