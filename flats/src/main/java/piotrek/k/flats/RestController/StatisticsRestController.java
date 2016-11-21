package piotrek.k.flats.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import piotrek.k.flats.Model.Statistics;
import piotrek.k.flats.Service.StatisticsService;

@RequestMapping(value = "/rest/statistics")
@RestController
public class StatisticsRestController {
	@Autowired
	StatisticsService statisticsService;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ResponseEntity<List<Statistics>> getAllStatistics() {

		return new ResponseEntity<List<Statistics>>(statisticsService.getAllStatistics(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Statistics> getStatisticById(@PathVariable("id") Long id) {

		return new ResponseEntity<Statistics>(statisticsService.getStatisticById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/area-{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Statistics>> getStatisticByAreaName(@PathVariable("name") String name) {

		return new ResponseEntity<List<Statistics>>(statisticsService.getStatisticsByAreaName(name), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/forCities-{city}", method = RequestMethod.GET)
	public ResponseEntity<List<Statistics>> getStatisticsForCities(@PathVariable("city") Boolean isCity) {

		return new ResponseEntity<List<Statistics>>(statisticsService.getStatisticsForCities(isCity), HttpStatus.OK);
	}

}
