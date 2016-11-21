package piotrek.k.flats.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Statistics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date statisticFrom;
	private Date statisticTo;
	private String areaName;
	private Boolean city;
	private Boolean flat;
	private Float price;
	private String dataSource;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStatisticFrom() {
		return statisticFrom;
	}
	public void setStatisticFrom(Date statisticFrom) {
		this.statisticFrom = statisticFrom;
	}
	public Date getStatisticTo() {
		return statisticTo;
	}
	public void setStatisticTo(Date statisticTo) {
		this.statisticTo = statisticTo;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Boolean getCity() {
		return city;
	}
	public void setCity(Boolean city) {
		this.city = city;
	}
	public Boolean getFlat() {
		return flat;
	}
	public void setFlat(Boolean flat) {
		this.flat = flat;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
