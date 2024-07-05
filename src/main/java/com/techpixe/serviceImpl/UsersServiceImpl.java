package com.techpixe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.Users;
import com.techpixe.repository.UsersRepository;
import com.techpixe.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public List<Users> all() {
		List<Users> all = usersRepository.findAll();
		if (all.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No Records are Present");
		}
		return all;
	}

	@Override
	public Users getByUserId(Long id) {
		Optional<Users> fetched = usersRepository.findById(id);
		if (fetched.isPresent()) {
			Users fetchedUser = fetched.get();
			return fetchedUser;
		} else {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"User with this id is not Present" + id);
		}
	}

	@Override
	public void deleteById(Long id) {
		usersRepository.deleteById(id);
	}

}
