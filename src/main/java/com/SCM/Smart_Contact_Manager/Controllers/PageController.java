package com.SCM.Smart_Contact_Manager.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/home")
	public String home(Model model) {
		
//		sending data to view
		System.out.println("Landing Home page ");
		model.addAttribute("Name", "Rohit");
		model.addAttribute("project", "Contact Manager");
		model.addAttribute("GithubRepo", "https://github.com/rohitsonkusale/Smart-Contact-Manager");
		return "Home";
	}

	// about page
	@RequestMapping("/about")
	public String aboutPage(){
		System.out.println("About Page Loading");
		return "about";
	}

	// service page
	@RequestMapping("/services")
	public String servicePage(){
		System.out.println("Service Page Loading");
		return "service";
	}

	@GetMapping("/contact")
	public String contact(){
		System.out.println("Contact Page Loading");
		return "contact";
	}

	@GetMapping("/login")
	public String login(){
		System.out.println("Service Page Loading");
		return "login";
	}

	@GetMapping("/register")
	public String register(){
		System.out.println("Singup Page Loading");
		return "register";
	}
}
