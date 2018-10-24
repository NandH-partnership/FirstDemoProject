package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.model.Credentials;
import com.model.User;
import com.services.Services;

@Controller
public class HomeController {

	@Autowired
	Services services;

	@RequestMapping("/")
	public String start() {
		System.out.println(" test branch login.");
		return "Login";
	}

	@RequestMapping("/registerpage")
	public String start1() {
		System.out.println(" test branch register.");
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

			return "UserData";
		
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
	
	public @ResponseBody String sendUserList(HttpServletResponse  response) {
		List<User>userList=services.getListByRoleId(3);
		String json=new Gson().toJson(userList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getOutputStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
		
	} 
	public @ResponseBody String sendManagerList(HttpServletResponse  response) {
		List<User>managerList=services.getListByRoleId(2);
		String json=new Gson().toJson(managerList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getOutputStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
		
	} 
	public @ResponseBody String sendAdminList(HttpServletResponse  response) {
		List<User>adminList=services.getListByRoleId(1);
		String json=new Gson().toJson(adminList);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getOutputStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return json;
		
	} 

}
