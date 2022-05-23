package com.fireprohibition.CBomb.web.dto;

import lombok.Data;

@Data
public class RegisterForm {
	private String username;
	private String password;
	private String passwordCheck;
}
