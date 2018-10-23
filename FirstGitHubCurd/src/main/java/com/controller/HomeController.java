package com.controller;

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

}
