package com.SCM.Smart_Contact_Manager.Entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "Contact")
public class Contact {

    @Id
    private String contactId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length = 10000)
    private String description;
    private boolean favorite;
    private String websiteLink;

    @ManyToOne
    private User user;

     @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLinks> links = new ArrayList<>();

    public Contact() {
        // TODO Auto-generated constructor stub
    }

    public Contact(String contactId, String name, String email, String phoneNumber, String address, String picture,
                   String description, boolean favorite, String websiteLink, User user) {
        super();
        this.contactId = contactId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.picture = picture;
        this.description = description;
        this.favorite = favorite;
        this.websiteLink = websiteLink;
        this.user = user;
    }

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}    
	
	
}
