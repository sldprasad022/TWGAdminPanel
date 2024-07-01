package com.techpixe.service;

import java.util.List;
import java.util.Optional;

import com.techpixe.entity.Packages;

public interface PackagesService {
	Packages create(String packageType, String packageAmount, Long noOfPosts, Long noOfReels, Long noOfArticles,
			Long noOfCustomizedFrames);

	Packages getById(Long packageId);

	List<Packages> all();

	void deletePackageById(Long packageId);

	Optional<Packages> updatePackage(Long packageId, String packageType, String packageAmount, Long noOfPosts,
			Long noOfReels, Long noOfArticles, Long noOfCustomizedFrames);
}
