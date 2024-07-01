package com.techpixe.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.techpixe.entity.Packages;

import com.techpixe.repository.PackagesRepository;
import com.techpixe.service.PackagesService;

@Service
public class PackagesServiceImpl implements PackagesService {
	@Autowired
	private PackagesRepository packagesRepository;

	@Override
	public Packages create(String packageType, String packageAmount, Long noOfPosts, Long noOfReels, Long noOfArticles,
			Long noOfCustomizedFrames) {
		Packages packages = new Packages();
		packages.setPackageType(packageType);
		packages.setPackageAmount(packageAmount);
		packages.setNoOfPosts(noOfPosts);
		packages.setNoOfReels(noOfReels);
		packages.setNoOfArticles(noOfArticles);
		packages.setNoOfCustomizedFrames(noOfCustomizedFrames);
		return packagesRepository.save(packages);
	}

	@Override
	public Packages getById(Long packageId) {
		return packagesRepository.findById(packageId).orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public List<Packages> all() {
		List<Packages> all = packagesRepository.findAll();
		if (all.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Packages are not Present");
		}
		return all;
	}

	public void deletePackageById(Long packageId) {
		packagesRepository.deleteById(packageId);
	}

	@Override
	public Optional<Packages> updatePackage(Long packageId, String packageType, String packageAmount, Long noOfPosts,
			Long noOfReels, Long noOfArticles, Long noOfCustomizedFrames) {
		return packagesRepository.findById(packageId).map(existingPackages -> {
			existingPackages.setPackageType(packageType != null ? packageType : existingPackages.getPackageType());
			existingPackages
					.setPackageAmount(packageAmount != null ? packageAmount : existingPackages.getPackageAmount());
			existingPackages.setNoOfPosts(noOfPosts != null ? noOfPosts : existingPackages.getNoOfPosts());
			existingPackages.setNoOfReels(noOfReels != null ? noOfReels : existingPackages.getNoOfReels());
			existingPackages.setNoOfArticles(noOfArticles != null ? noOfArticles : existingPackages.getNoOfArticles());
			existingPackages.setNoOfCustomizedFrames(
					noOfCustomizedFrames != null ? noOfCustomizedFrames : existingPackages.getNoOfCustomizedFrames());

			return packagesRepository.save(existingPackages);
		});
	}

}
