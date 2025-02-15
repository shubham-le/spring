package com.jpa.app.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity(name = "user_master")
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column
	private String name;

	@Column
	private String email;

	@Embedded
	private AuditCol auditCol;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "user_role", 
		joinColumns = @JoinColumn(name = "userId"), 
		inverseJoinColumns = @JoinColumn(name= "roleId"))
	private Set<RoleMaster> roleMaster;
}
