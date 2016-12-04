package piotrek.k.flats.DTO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class PasswordDTO {

	@NotEmpty
	@Size(min = 4, max = 35)
	private String oldPassword;

	@NotEmpty
	@Size(min = 4, max = 35)
	private String newPassword;

	@NotEmpty
	@Size(min = 4, max = 35)
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
