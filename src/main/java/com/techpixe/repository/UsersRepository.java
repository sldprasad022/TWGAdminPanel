package com.techpixe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpixe.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
