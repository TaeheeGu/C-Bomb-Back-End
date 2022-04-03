package com.fireprohibition.CBomb.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username", unique = true)
	private String userId;

	private String password;

	private boolean enable;

	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles = new ArrayList<>();
}
