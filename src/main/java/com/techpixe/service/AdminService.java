package com.techpixe.service;

import org.springframework.http.ResponseEntity;

public interface AdminService {
	ResponseEntity<?> loginByEmail(String email, String Password);
}
