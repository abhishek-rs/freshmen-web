package com.freshmen.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.freshmen.model.UserCredentials;

@Controller
public class PageNavigationController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String helloLST() {
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		UserCredentials userCredentials = new UserCredentials();
		model.addObject("loginBean", userCredentials);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") UserCredentials userCredentials) {
		ModelAndView model = null;
		try {
			boolean isValidUser = true; // Have to Add db logics here
			if (isValidUser) {
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", userCredentials.getUsername());
				model = new ModelAndView("studenthome");
			} else {
				model = new ModelAndView("login");
				model.addObject("loginBean", userCredentials);
				request.setAttribute("message", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}

	@RequestMapping(value = "/tutorhome", method = RequestMethod.GET)
	public String tutorhome() {
		return "tutorhome";
	}

	@RequestMapping(value = "/studenthome", method = RequestMethod.GET)
	public String studenthome() {
		return "studenthome";
	}

	@RequestMapping(value = "/coordinatorhome", method = RequestMethod.GET)
	public String coordinatorview() {
		return "coordinatorview";
	}
}
