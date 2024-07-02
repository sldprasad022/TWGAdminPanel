package com.techpixe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techpixe.dto.ErrorResponseDto;
import com.techpixe.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	private boolean isEmail(String email) {
		return email.contains("@");
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String email, @RequestParam String Password) {
		if (email != null) {
			if (isEmail(email)) {
				return adminService.loginByEmail(email, Password);
			} else {
				ErrorResponseDto errorResponseDto = new ErrorResponseDto();
				errorResponseDto.setError("Invalid email or Password");
				return ResponseEntity.internalServerError().body(errorResponseDto);
			}
		} else {
			ErrorResponseDto errorResponseDto = new ErrorResponseDto();
			errorResponseDto.setError("Invalid email or Password");
			return ResponseEntity.internalServerError().body(errorResponseDto);
		}
	}
}
