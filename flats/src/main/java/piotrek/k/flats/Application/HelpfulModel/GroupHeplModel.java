package piotrek.k.flats.Application.HelpfulModel;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupHeplModel {

	public GroupHeplModel(AttributeName name, Integer importanceValue, Integer sumOfValues) {
		this.name = name;
		this.importanceValue = importanceValue;
		this.sumOfValuesInGroup = sumOfValues;
	}

	private AttributeName name;
	private Integer importanceValue;
	private Integer sumOfValuesInGroup;
	
	@Override
	public String toString() {
		return "GroupHeplModel: [name=" + name + ", importanceValue=" + importanceValue + ", sumOfValues=" + sumOfValuesInGroup
				+ "]";
	}

}
