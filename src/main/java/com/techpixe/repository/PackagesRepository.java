package com.techpixe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techpixe.entity.Packages;

public interface PackagesRepository extends JpaRepository<Packages, Long> {

}
