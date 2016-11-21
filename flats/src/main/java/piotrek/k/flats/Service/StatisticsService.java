package piotrek.k.flats.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import piotrek.k.flats.DAO.IStatisticsInterface;
import piotrek.k.flats.Model.Statistics;

@Service
public class StatisticsService {

	@Autowired
	IStatisticsInterface iStatisticsInterface;

	public List<Statistics> getAllStatistics() {
		return iStatisticsInterface.findAll();
	}

	public Statistics getStatisticById(Long id) {
		return iStatisticsInterface.findById(id);
	}

	public void addStatistic(Statistics statistics) {
		iStatisticsInterface.save(statistics);
	}

	public void deleteStatistic(Long id) {
		iStatisticsInterface.delete(id);
	}

	public List<Statistics> getStatisticsByAreaName(String areaName) {
		return iStatisticsInterface.findByAreaName(areaName);
	}

	public List<Statistics> getStatisticsForCities(Boolean city) {
		return iStatisticsInterface.findByCity(city);
	}

	public List<Statistics> getBetweenDate(Date statisticFrom, Date statisticTo) {
		return iStatisticsInterface.findByStatisticFromAfterAndStatisticToBefore(statisticFrom, statisticTo);
	}
}
