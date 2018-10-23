package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Credentials;
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
}
@RequestMapping("/login")
public String login(@ModelAttribute Credentials credentials,Model model) {
	
	return null;
	
}
}
