package com.controller;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.services.Services;

@Controller
public class HomeController {
@Autowired
Services service;


@RequestMapping("/")
public String start()
{
	return "Login";
}
@RequestMapping("/registerpage")
public String start1()
{
	return "Registration";
}
=======
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Credentials;
import com.model.User;
import com.services.Services;

@Entity
public class HomeController {
	@Autowired
	private Services services;

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}
>>>>>>> cf9c934f8925faa50bbdde6c415d37080ee064f6

	@RequestMapping("/save")
	public String saveUser(@ModelAttribute User user,@ModelAttribute Credentials credentials
			,Model model) {
		int i=services.saveUser(user,credentials);
	}
}
