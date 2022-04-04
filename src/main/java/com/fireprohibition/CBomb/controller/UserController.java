package com.fireprohibition.CBomb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fireprohibition.CBomb.dto.RegisterForm;
import com.fireprohibition.CBomb.domain.user.UserRepository;
import com.fireprohibition.CBomb.service.RegisterService;

@Controller
public class UserController {

	@Autowired
	private RegisterService registerService;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/login")
	public String loginPage() {
		return "/loginForm";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "/register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute RegisterForm form,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/register";
		} else if(userRepository.findByUsername(form.getUsername()).isPresent()){
			bindingResult.reject("registerFail", "이미 존재하는 아이디입니다.");
			return "/register";
		} else if (!form.getPassword().equals(form.getPasswordCheck())) {
			bindingResult.reject("registerFail", "비밀번호가 일치하지 않습니다.");
			return "/register";
		}
		registerService.joinUser(form.getUsername(), form.getPassword());
		return "redirect:/";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
