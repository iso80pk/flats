package piotrek.k.flats.Application.HelpfulModel;

public enum AttributeName {
	Location("Lokalizacja"),
	RealEstateType("Typ nieruchomosci"), 
	FloorArea("Powierzchnia"), 
	Price("Cena"), 
	NumberOfRooms("Ilosc pokoi"), 
	HowOld("Wiek"), 
	Floor("Pietro"), 
	Garage("Garaz"), 
	Parking("Parking"), 
	Garden("Ogrod"), 
	Cellar("Piwnica"), 
	Monitoring("Monitoring"), 
	Lift("Winda"),
	AccessToPublicTransport("Dostep do publicznego transportu");
	
	private String value;
	 public String getValue() {
	    return value;
	   }
	 private AttributeName(String value) {
	  this.value = value;
	 } 
}
