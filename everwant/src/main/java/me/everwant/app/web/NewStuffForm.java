package me.everwant.app.web;

import javax.inject.Inject;

import me.everwant.app.domain.Stuff;
import me.everwant.app.service.StuffService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/stuff/new")
public class NewStuffForm {

    private static final Logger logger = LoggerFactory.getLogger(NewStuffForm.class);

	@Inject
	private StuffService stuffService;

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
		Stuff stuff = new Stuff();
		model.addAttribute("stuff", stuff);
		return "newStuffForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public String processSubmit(@ModelAttribute("stuff") Stuff stuff, BindingResult result, SessionStatus status) {
        status.setComplete();
        logger.debug(stuff.toString());
        stuffService.save(stuff);
        return "redirect:/";
    }

}
