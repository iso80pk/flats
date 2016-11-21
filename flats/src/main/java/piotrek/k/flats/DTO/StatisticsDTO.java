package piotrek.k.flats.DTO;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class StatisticsDTO {
	
	
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date statisticFrom;
	

	@DateTimeFormat(pattern = "dd.MM.yyyy")
	private Date statisticTo;
	
	
	@Size(min = 3, max = 35)
	private String areaName;
	
	
	private Boolean city;
	
	
	private Boolean flat;
	
	@NotNull
	@DecimalMin("10.0")
	private Float price;
	
	@NotNull
	@Size(min = 4, max = 255)
	private String dataSource;
	

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

}
