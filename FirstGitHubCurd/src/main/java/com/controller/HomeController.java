package com.controller;

<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Credentials;
import com.model.User;
=======
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

>>>>>>> ea8479d7951af707c36e9c7cce3c96b4e24d1f8c
import com.services.Services;

@Controller
public class HomeController {
<<<<<<< HEAD
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
=======
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
>>>>>>> ea8479d7951af707c36e9c7cce3c96b4e24d1f8c
	}
}
