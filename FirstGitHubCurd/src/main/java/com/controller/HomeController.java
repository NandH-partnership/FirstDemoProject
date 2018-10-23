package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Credentials;
import com.model.User;
import com.services.Services;

@Controller
public class HomeController {
	@Autowired
	private Services services;

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	@RequestMapping("/save")
	public String saveUser(@ModelAttribute User user, @ModelAttribute Credentials credentials, Model model) {

		int i = services.saveUser(user, credentials);
		if (i == 0) {
			model.addAttribute("msg", "Registration failed");
		}else{
			model.addAttribute("msg", "Registration successfull");
		}
		return "Login";
	}
}
