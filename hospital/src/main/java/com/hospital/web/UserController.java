package com.hospital.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hospital.model.User;
import com.hospital.repositories.UserRespository;

@Controller
@RequestMapping(value = "/")
public class UserController {

	@Autowired
	private UserRespository userRepository;

	public static User logedUser;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("login") User user, Errors error, Model model) {
		String page = null;
		User userResult = userRepository.findUser(user.getUsername(), user.getPassword());
		if (userResult != null) {
			logedUser = userResult;
			model.addAttribute("userprofile", logedUser);
			page = "mainPage";
		}

		else {
			model.addAttribute("login", user);
			model.addAttribute("errorMessage", "Either password or username is incorrect!!");
			page = "home";
		}
		return page;
	}
}
