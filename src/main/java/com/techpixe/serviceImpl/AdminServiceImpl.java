package com.techpixe.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.dto.AdminDTO;
import com.techpixe.entity.Admin;
import com.techpixe.repository.AdminRepository;
import com.techpixe.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public ResponseEntity<?> loginByEmail(String email, String Password) {
		Admin admin1 = adminRepository.findByEmail(email);

		if (admin1 != null && admin1.getPassword().equals(Password)) {
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setId(admin1.getId());
			adminDTO.setName(admin1.getName());
			adminDTO.setEmail(email);
			adminDTO.setPassword(Password);
			adminDTO.setRole(admin1.getRole());

			return ResponseEntity.ok(adminDTO);
		} else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Invalid email or Password and Please Try again");
		}
	}

}
