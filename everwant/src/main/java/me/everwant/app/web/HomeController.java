package me.everwant.app.web;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import me.everwant.app.domain.Stuff;
import me.everwant.app.service.StuffService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Inject
	private StuffService stuffService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! the client locale is " + locale.toString());

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		List<Stuff> stuffs = stuffService.listStuffs();

		if (stuffs != null) {
			logger.info("stuff size: " + stuffs.size());

			List<String> stuffNames = new ArrayList<String>();
			for (Stuff stuff : stuffs) {
				stuffNames.add(stuff.getName());
			}
			model.addAttribute("stuffs", stuffNames);

		} else {
			logger.info("stuff size is zero ");
		}

		return "home";
	}


}
