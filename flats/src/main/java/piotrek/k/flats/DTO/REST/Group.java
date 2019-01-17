package piotrek.k.flats.DTO.REST;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString
public class Group {
	private Long id;
	private Integer degree;
	private String name;
	private Double importance;
	private List<Attributes> atributes = new ArrayList<>();

	public Group(Long id, Integer degree, String name, Double importance) {
		this.id = id;
		this.degree = degree;
		this.name = name;
		this.importance = importance;
	}

	public Group() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getImportance() {
		return importance;
	}

	public void setImportance(Double importance) {
		this.importance = importance;
	}

	public List<Attributes> getAtributes() {
		return atributes;
	}

	public void setAtributes(List<Attributes> atributes) {
		this.atributes = atributes;
	}

}
