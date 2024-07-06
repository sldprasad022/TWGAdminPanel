package com.techpixe.service;

import java.util.List;
import java.util.Optional;

import com.techpixe.entity.Users;

public interface UsersService {
	List<Users> all();

	Users getByUserId(Long id);

	void deleteById(Long id);

	Optional<Users> updateUsers(Long id, String Name, String Email, String Mobile, String Password);

	public long getTotalUsersCount();
}
