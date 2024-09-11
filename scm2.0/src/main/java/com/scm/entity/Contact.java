package com.scm.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Contact {
   @Id
	private String Id;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	
	private String picture;
	@Column(columnDefinition = "TEXT")
	private String discription;
	private boolean favourite=false;
	private String websiteLink;
	private String linkedInLink;
	//private List<String> socialLinks=new  ArrayList<>();
    @OneToOne
	private User user;
    
    @OneToMany(mappedBy="contact",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
    private List<SocialLink> link=new ArrayList<>();
}
