package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class PasswordDTO {

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 4, max = 35, message="Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String oldPassword;

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 4, max = 35, message="Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String newPassword;

	@NotEmpty(message="Pole jest wymagane")
	@Size(min = 4, max = 35, message="Pole mo¿e zawieraæ od 4 do 35 znaków")
	private String repetedNewPassword;

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRepetedNewPassword() {
		return repetedNewPassword;
	}

	public void setRepetedNewPassword(String repetedNewPassword) {
		this.repetedNewPassword = repetedNewPassword;
	}

}
