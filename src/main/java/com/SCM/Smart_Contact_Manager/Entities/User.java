package com.SCM.Smart_Contact_Manager.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.Getter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.*;

import jakarta.persistence.OneToMany;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Builder
@Data
@Entity
@Table(name = "User")
public class User {

	@Id
	@Column(name = "UserId")
	private String userId;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "Email", unique = true, nullable = false)
	private String email;

	@Column(name = "About", columnDefinition = "TEXT")
	private String about;

	@Column(name = "profilePic", columnDefinition = "TEXT")
	private String profilePic;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	private boolean enabled = false;
	private boolean emailVerified = false;
	private boolean phoneVerified = false;

	// SELF, GOOGLE, GITHUB
	private Providers Provider = Providers.SELF;
	private String providerId;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Contact> contact = new ArrayList<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String userName, String password, String email, String about, String profilePic,
			String phoneNumber, boolean enabled, boolean emailVerified, boolean phoneVerified, Providers provider,
			String providerId, List<Contact> contact) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.about = about;
		this.profilePic = profilePic;
		this.phoneNumber = phoneNumber;
		this.enabled = enabled;
		this.emailVerified = emailVerified;
		this.phoneVerified = phoneVerified;
		Provider = provider;
		this.providerId = providerId;
		this.contact = contact;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isPhoneVerified() {
		return phoneVerified;
	}

	public void setPhoneVerified(boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	public Providers getProvider() {
		return Provider;
	}

	public void setProvider(Providers provider) {
		Provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public List<Contact> getContact() {
		return contact;
	}

	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}

}
