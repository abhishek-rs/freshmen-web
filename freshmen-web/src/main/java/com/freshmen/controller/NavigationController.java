package com.freshmen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigationController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String helloLST() {
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/tutorhome", method = RequestMethod.GET)
	public String tutorhome() {
		return "tutorhome";
	}

	@RequestMapping(value = "/studenthome", method = RequestMethod.GET)
	public String studenthome() {
		return "studenthome";
	}
}
