package com.SCM.Smart_Contact_Manager.Forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserForm {

	@NotBlank(message = "Username is required")
	@Size(min = 3, message = "Minimum 3 Character is required")
    public String userName;
	
	@Email(message = "Invaild Email address")
	@NotBlank(message = "Email is required")
    public String email;
	
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Minimum 6 character is required")
    public String password;
	
	@NotBlank(message = "About is reqiured")
    public String about;
	
	@Size(min = 8, max = 12, message = "Invalid Phone Number")
    public String phoneNumber;
    
    public UserForm() {
		// TODO Auto-generated constructor stub
	}

	public UserForm(String userName, String email, String password, String about, String phoneNumber) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.about = about;
		this.phoneNumber = phoneNumber;
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
}
