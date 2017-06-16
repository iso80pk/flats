package piotrek.k.flats.DTO;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class RealEstateUserDTO {

	private RealEstateDTO realEstateDTO;
	
	private String nammedByUser;
	private Integer rankedPosition;
	private Float adaptation; // dopasowanie
	private Boolean fulfillsAllUserExpectation;
	private Boolean favorite;
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "99999999.99", message = "Maksymalna wartoœæ to 99999999.99")
	private Double ownContribution;
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "9999.99", message = "Maksymalna wartoœæ to 9999.99")
	private Double kmPerDay;
	@DecimalMin(value = "0.0", message = "Minimalna wartoœæ to 0")
	@DecimalMax(value = "99999.99", message = "Maksymalna wartoœæ to 99999.99")
	private Double maintenanceCosts;
	private String notes;
	public RealEstateDTO getRealEstateDTO() {
		return realEstateDTO;
	}
	public void setRealEstateDTO(RealEstateDTO realEstateDTO) {
		this.realEstateDTO = realEstateDTO;
	}
	public String getNammedByUser() {
		return nammedByUser;
	}
	public void setNammedByUser(String nammedByUser) {
		this.nammedByUser = nammedByUser;
	}
	public Integer getRankedPosition() {
		return rankedPosition;
	}
	public void setRankedPosition(Integer rankedPosition) {
		this.rankedPosition = rankedPosition;
	}
	public Float getAdaptation() {
		return adaptation;
	}
	public void setAdaptation(Float adaptation) {
		this.adaptation = adaptation;
	}
	public Boolean getFulfillsAllUserExpectation() {
		return fulfillsAllUserExpectation;
	}
	public void setFulfillsAllUserExpectation(Boolean fulfillsAllUserExpectation) {
		this.fulfillsAllUserExpectation = fulfillsAllUserExpectation;
	}
	public Boolean getFavorite() {
		return favorite;
	}
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
	public Double getOwnContribution() {
		return ownContribution;
	}
	public void setOwnContribution(Double ownContribution) {
		this.ownContribution = ownContribution;
	}
	public Double getKmPerDay() {
		return kmPerDay;
	}
	public void setKmPerDay(Double kmPerDay) {
		this.kmPerDay = kmPerDay;
	}
	public Double getMaintenanceCosts() {
		return maintenanceCosts;
	}
	public void setMaintenanceCosts(Double maintenanceCosts) {
		this.maintenanceCosts = maintenanceCosts;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}	
	
}
