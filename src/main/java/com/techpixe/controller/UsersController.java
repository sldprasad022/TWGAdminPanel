package com.techpixe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.Users;
import com.techpixe.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	@GetMapping("/all")
	public ResponseEntity<List<Users>> allData() {
		List<Users> all = usersService.all();
		return new ResponseEntity<List<Users>>(all, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Long id) {
		Users fetched = usersService.getByUserId(id);
		return new ResponseEntity<Users>(fetched, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		Users deleteById = usersService.getByUserId(id);
		if (deleteById == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			System.out.println("*********User is Deleted" + id);
			usersService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestParam(required = false) String Name,
			@RequestParam(required = false) String Email, @RequestParam(required = false) String Mobile,
			@RequestParam(required = false) String Password) {
		Optional<Users> updatedUsers = usersService.updateUsers(id, Name, Email, Mobile, Password);
		return updatedUsers.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/count")
	public ResponseEntity<Long> totalUsersCount() {
		Long totalUsers = usersService.getTotalUsersCount();
		return new ResponseEntity<Long>(totalUsers, HttpStatus.OK);
	}

}
