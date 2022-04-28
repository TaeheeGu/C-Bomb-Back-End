package com.fireprohibition.CBomb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fireprohibition.CBomb.domain.user.Role;
import com.fireprohibition.CBomb.domain.user.User;
import com.fireprohibition.CBomb.domain.user.UserRepository;

@Service
public class RegisterService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void joinUser(String username, String password) {
		User user = User.builder()
				.username(username)
				.password(passwordEncoder.encode(password))
				.role(Role.USER)
				.build();
		userRepository.save(user);
	}

}
