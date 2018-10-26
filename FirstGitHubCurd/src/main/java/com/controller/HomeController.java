package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		switch (user.getRole().getRoleid()) {
		case 1:
			model.addAttribute("admin",user);

			return "Admin";
		case 2:
			
			model.addAttribute("manager",user);

			return "Manager";
		case 3:
			model.addAttribute("user",user);

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
	@RequestMapping("/getUserList")
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
	
	@RequestMapping("/getManagerList")
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
	@RequestMapping("/getAdminList")
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
	@RequestMapping("/edit")
	public @ResponseBody String editlist( int id,HttpServletResponse response) {
	
		
		User user=services.getSingleUser(id);
		String json=new Gson().toJson(user);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getOutputStream();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		return json;
	
	}
	@RequestMapping(value="/update",method=RequestMethod.PUT,consumes="application/json")

	public @ResponseBody  String updateuser(@RequestBody User user,HttpServletResponse response) throws IOException {
		
		System.out.println(user.getCredentials().getPassword());
		System.out.println(user.getCredentials().getUsername());
		System.out.println(user.getRole().getRoleid());
		
		services.updateUser(user);
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
	
	@RequestMapping("/remove")
	public @ResponseBody String removeUser(@RequestParam int id,HttpServletResponse response) {
		int i=services.removeUser(id);
		System.out.println("remove ==="+i);
		String json=new Gson().toJson(i);
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
