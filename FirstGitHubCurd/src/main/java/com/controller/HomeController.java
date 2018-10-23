package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Credentials;
import com.model.Role;
import com.model.User;
import com.services.Services;

@Controller
public class HomeController {

	@Autowired
	Services services;

	@RequestMapping("/")
	public String start() {
		return "Login";
	}

	@RequestMapping("/registerpage")
	public String start1() {
		return "Registration";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute Credentials credentials, Model model) {

		User user=services.getSingleUser(credentials);
		model.addAttribute("user",user);
		switch (user.getRole().getRoleid()) {
		case 1:
			model.addAttribute("msg","admin");

			return "Login";
		case 2:
			
			model.addAttribute("msg","manager");

			return "Login";
		case 3:
			model.addAttribute("msg","user");

			return "Login";
		
		default:
			return "Login";
		}
		

	}

	@RequestMapping("/save")
	public String saveUser(@ModelAttribute User user, @ModelAttribute Credentials credentials,@RequestParam int roleid,Model model) {

		int i = services.saveUser(user, credentials,roleid);
		if (i == 0) {
			model.addAttribute("msg", "Registration failed");
		} else {
			model.addAttribute("msg", "Registration successfull");
		}
		return "Login";
	}

}
