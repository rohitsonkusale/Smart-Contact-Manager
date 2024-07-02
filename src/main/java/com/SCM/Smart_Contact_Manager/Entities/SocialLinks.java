package com.SCM.Smart_Contact_Manager.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table
@Builder
public class SocialLinks {

	@Id
    private long id;
    private String link;
    private String title;

    public SocialLinks() {
		
	}

	public SocialLinks(long id, String link, String title) {
		super();
		this.id = id;
		this.link = link;
		this.title = title;
	}
	
	@ManyToOne
	private Contact contact;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
    
    
}
