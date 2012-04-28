package me.everwant.app.web;

import javax.inject.Inject;
import javax.validation.Valid;

import me.everwant.app.data.UserRepository;
import me.everwant.app.domain.Registration;
import me.everwant.app.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles registration requests.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

	private static final Logger logger = LoggerFactory
			.getLogger(RegistrationController.class);

	@Inject
	private UserRepository userRepository;

	@Inject
	private PasswordEncoder passwordEncoder;

	@ModelAttribute("registration")
	public Registration createRegistration() {
		return new Registration();
	}

	// Display the form on the get request
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration() {
		return "registrationform";
	}

	// Process the form.
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid Registration registration,
			BindingResult result) {
		String username = registration.getUserName();
		if (userRepository.findByName(username) != null) {
			result.rejectValue("userName", "username.taken",
					"User Name is taken.");
		}

		if (!(registration.getPassword()).equals(registration
				.getConfirmPassword())) {
			result.rejectValue("password",
					"matchingPassword.registration.password",
					"Password and Confirm Password Do Not match.");
		}

		if (userRepository.findByEmail(registration.getEmail()) != null) {
			result.rejectValue("email", "email.taken", "email has been used.");
		}

		if (result.hasErrors()) {
			return "registrationform";
		}
		User newuser = new User();
		newuser.setName(registration.getUserName());
		newuser.setEmail(registration.getEmail());
		newuser.setPassword(passwordEncoder.encodePassword(
				registration.getPassword(), username));
		
		logger.info("user to be added: " + newuser);
		
		userRepository.add(newuser);

		return "redirect:/login";
	}
}
