package com.fireprohibition.CBomb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String register(@ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/register";
		} else if(userRepository.findByUsername(registerForm.getUsername()).isPresent()){
			bindingResult.addError(new FieldError("registerForm", "username", "이미 존재하는 아이디 입니다."));
			return "/register";
		} else if (!registerForm.getPassword().equals(registerForm.getPasswordCheck())) {
			bindingResult.addError(new FieldError("registerForm", "passwordCheck", "비밀번호가 일치하지 않습니다."));
			return "/register";
		}
		registerService.joinUser(registerForm.getUsername(), registerForm.getPassword());
		return "redirect:/";
	}

	@PostMapping("/register/find-same-name")
	@ResponseBody
	public String findSameName(@RequestParam("usernmae") String username) {
		if(userRepository.findByUsername(username).isPresent())
			return "False";
		return "True";
	}

	@GetMapping("/test")
	public @ResponseBody
	String test() {
		return "접근가능";
	}
}
