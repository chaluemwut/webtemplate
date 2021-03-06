package com.nsc.webtemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nsc.webtemplate.model.UsersRepository;

@Controller
public class LoginController {

	@Autowired
	private UsersRepository repository;

	@RequestMapping("/")
	public ModelAndView mainPage() {
		// repository.save(new Users("demo", "demo", "admin"));
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("message", "Welcome to Spring MVC!");
		return mv;
	}

}