package com.SCM.Smart_Contact_Manager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SCM.Smart_Contact_Manager.Entities.User;
import com.SCM.Smart_Contact_Manager.Forms.UserForm;
import com.SCM.Smart_Contact_Manager.Services.UserService;
import com.SCM.Smart_Contact_Manager.helpers.Message;
import com.SCM.Smart_Contact_Manager.helpers.MessageType;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

	@Autowired
	private UserService userService;
	
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
	public String register(Model model){
		// we wre sending empty object from here to store the data from form-feilds 
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);

		return "register";
	}

	//processing register
	@PostMapping("/do-register")
	public String processingRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
		System.out.println("processing registration");
		//fetch form data

		//validate form data
		if(rBindingResult.hasErrors()) {
			return "register";
		}
		//save to database
		
		// Userform---> user 
		
		
		// User user = User.builder()
		// 		.userName(userForm.getuserName())
		// 		.email(userForm.getEmail())
		// 		.password(userForm.getPassword())
		// 		.phoneNumber(userForm.getPhoneNumber())
		// 		.about(userForm.getAbout())
		// 		.profilePic()
		// 		.build();
		
		User user = new User();
		user.setname(userForm.getuserName());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setPhoneNumber(userForm.getPhoneNumber());
		user.setAbout(userForm.getAbout());
		user.setProfilePic("");		
		
//		user service
		User savedUser = userService.saveUser(user);
		System.out.println(savedUser);
		
		
		//message = "Registration Sucessful"

		//		add the message 
		
//		Message message = Message.builder().content("Registration Successful").type(MessageType.RED).build();
//	    session.setAttribute("message", message);
		
		Message message = new Message();
        message.setContent("Registration Successful");
        message.setType(MessageType.green);
		session.setAttribute("message", message);
		
		// return "redirect:/login";
		return "redirect:/register";
	}
}
