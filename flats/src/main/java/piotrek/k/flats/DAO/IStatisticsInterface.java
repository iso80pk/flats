package piotrek.k.flats.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import piotrek.k.flats.Model.Statistics;

public interface IStatisticsInterface extends CrudRepository<Statistics, Long> {

	public List<Statistics> findAll();

	public Statistics findById(Long id);

	public List<Statistics> findByAreaName(String areaName);

	public List<Statistics> findByCity(Boolean city);

	public List<Statistics> findByFlat(Boolean flat);

	public List<Statistics> findByAreaNameAndFlat(String areaName, Boolean flat);

	public List<Statistics> findByStatisticFromAfter(Date statisticFrom);

	public List<Statistics> findByStatisticToBefore(Date statisticTo);
	
	public List<Statistics> findByStatisticFromAfterAndStatisticToBefore(Date statisticFrom, Date statisticTo);

}
