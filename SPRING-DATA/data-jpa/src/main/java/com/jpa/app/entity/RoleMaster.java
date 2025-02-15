package com.jpa.app.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity @Data
public class RoleMaster {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	@Column
	private String roleName;
	
	@ManyToMany(mappedBy = "roleMaster", fetch = FetchType.EAGER)
	private Set<UserMaster> userMaster;
}
