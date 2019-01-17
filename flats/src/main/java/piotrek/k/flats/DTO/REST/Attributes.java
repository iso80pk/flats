package piotrek.k.flats.DTO.REST;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attributes {

	private String name;
	private Integer importance;

	// public Attributes(String name, Integer importance) {
	// this.name = name;
	// this.importance = importance;
	// }

}
