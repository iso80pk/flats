package piotrek.k.flats.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Priority")
public class Priority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer	degreeOfValidity;
	private String name;
	private Double importance;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
