package piotrek.k.flats.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Priority")
public class Priority {
	
	public Priority() {
	}

	public Priority(Integer degree, String name, Double importance, User user) {
		super();
		this.degree = degree;
		this.name = name;
		this.importance = importance;
		this.user = user;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer degree;
	private String name;
	private Double importance;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
