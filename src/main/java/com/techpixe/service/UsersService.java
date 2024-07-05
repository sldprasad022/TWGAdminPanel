package com.techpixe.service;

import java.util.List;

import com.techpixe.entity.Users;

public interface UsersService {
	List<Users> all();

	Users getByUserId(Long id);

	void deleteById(Long id);
}
