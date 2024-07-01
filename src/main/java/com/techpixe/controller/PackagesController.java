package com.techpixe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techpixe.entity.Packages;
import com.techpixe.service.PackagesService;

@RestController
@RequestMapping("/packages")
public class PackagesController {
	@Autowired
	private PackagesService packagesService;

	@PostMapping("/createPackage")
	public ResponseEntity<Packages> create(@RequestParam String packageType, @RequestParam String packageAmount,
			@RequestParam Long noOfPosts, @RequestParam Long noOfReels, @RequestParam Long noOfArticles,
			@RequestParam Long noOfCustomizedFrames) {
		Packages savedPackages = packagesService.create(packageType, packageAmount, noOfPosts, noOfReels, noOfArticles,
				noOfCustomizedFrames);
		return new ResponseEntity<Packages>(savedPackages, HttpStatus.CREATED);

	}

	@GetMapping("/fetched/{packageId}")
	public ResponseEntity<Packages> getById(@PathVariable Long packageId) {
		Packages fetchedPackages = packagesService.getById(packageId);
		return new ResponseEntity<Packages>(fetchedPackages, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Packages>> all() {
		List<Packages> fetchedAll = packagesService.all();
		return new ResponseEntity<List<Packages>>(fetchedAll, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{packageId}")
	public ResponseEntity<Void> deleteProjectById(@PathVariable Long packageId) {
		Packages fetchedPackage = packagesService.getById(packageId);
		if (fetchedPackage == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			packagesService.deletePackageById(packageId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@PutMapping("/update/{packageId}")
	public ResponseEntity<Packages> update(@PathVariable Long packageId,
			@RequestParam(required = false) String packageType, @RequestParam(required = false) String packageAmount,
			@RequestParam(required = false) Long noOfPosts, @RequestParam(required = false) Long noOfReels,
			@RequestParam(required = false) Long noOfArticles,
			@RequestParam(required = false) Long noOfCustomizedFrames) {
		Optional<Packages> updated = packagesService.updatePackage(packageId, packageType, packageAmount, noOfPosts,
				noOfReels, noOfArticles, noOfCustomizedFrames);
		return updated.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
