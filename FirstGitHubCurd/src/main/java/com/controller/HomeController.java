package com.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.Services;

@Controller
public class HomeController {
@Autowired
Services services;


@RequestMapping("/")
public String start()
{
	return "Login";
}
@RequestMapping("/registerpage")
public String start1()
{
	return "Registration";
}	@RequestMapping("/save")
	public String saveUser(@ModelAttribute User user,@ModelAttribute Credentials credentials
			,Model model) {
		int i=services.saveUser(user,credentials);
	}
}
