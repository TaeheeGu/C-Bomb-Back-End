package com.fireprohibition.CBomb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fireprohibition.CBomb.domain.user.Role;
import com.fireprohibition.CBomb.domain.user.User;
import com.fireprohibition.CBomb.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public void joinUser(String username, String password) {
		User user = User.builder()
				.username(username)
				.password(passwordEncoder.encode(password))
				.role(Role.USER)
				.build();
		userRepository.save(user);
	}
	public void joinUser(String username, String password, Role role) {
		User user = User.builder()
				.username(username)
				.password(passwordEncoder.encode(password))
				.role(role)
				.build();
		userRepository.save(user);
	}

}
