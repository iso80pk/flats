package piotrek.k.flats.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piotrek.k.flats.DTO.StatisticsDTO;
import piotrek.k.flats.Model.Statistics;
import piotrek.k.flats.Service.StatisticsService;
import piotrek.k.flats.Service.UserService;

@RequestMapping(value = "/statistics")
@Controller
public class StatisticsController {

	@Autowired
	StatisticsService statisticsService;

	@Autowired
	UserService userService;

	@ModelAttribute("form")
	public StatisticsDTO getStatisticsForm() {
		return new StatisticsDTO();
	}

	@Secured({ "ROLE_USER" })
	@RequestMapping(value = "/")
	public String allStatistics(Model model) {
		model.addAttribute("statistics", statisticsService.getAllStatistics());
		return "statistics/statisticsList";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String statisticsFormGet() {
		return "statistics/statisticsForm";
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String statisticsFormPost(@ModelAttribute("form") @Valid StatisticsDTO form, BindingResult result) {
		if (result.hasErrors())
			return "statistics/statisticsForm";
		else {
			Statistics statistics = new Statistics();
			statistics.setAreaName(form.getAreaName());
			statistics.setCity(form.getCity());
			statistics.setDataSource(form.getDataSource());
			statistics.setFlat(form.getFlat());
			statistics.setPrice(form.getPrice());
			statistics.setStatisticFrom(form.getStatisticFrom());
			statistics.setStatisticTo(form.getStatisticTo());
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			statistics.setUser(userService.getByUsername(user.getUsername()));
			statisticsService.addStatistic(statistics);
			return "redirect:/statistics/";
		}
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping(value = "/delete-{id}")
	public String statisticDeleteById(@PathVariable("id") Long idStatistic) {
		statisticsService.deleteStatistic(idStatistic);
		return "redirect:/statistics/";
	}

}
