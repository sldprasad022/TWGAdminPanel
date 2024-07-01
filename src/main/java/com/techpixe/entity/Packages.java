package com.techpixe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageId;

	private String packageType;

	private String packageAmount;

	private Long noOfPosts;

	private Long noOfReels;

	private Long noOfArticles;

	private Long noOfCustomizedFrames;

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public String getPackageAmount() {
		return packageAmount;
	}

	public void setPackageAmount(String packageAmount) {
		this.packageAmount = packageAmount;
	}

	public Long getNoOfPosts() {
		return noOfPosts;
	}

	public void setNoOfPosts(Long noOfPosts) {
		this.noOfPosts = noOfPosts;
	}

	public Long getNoOfReels() {
		return noOfReels;
	}

	public void setNoOfReels(Long noOfReels) {
		this.noOfReels = noOfReels;
	}

	public Long getNoOfArticles() {
		return noOfArticles;
	}

	public void setNoOfArticles(Long noOfArticles) {
		this.noOfArticles = noOfArticles;
	}

	public Long getNoOfCustomizedFrames() {
		return noOfCustomizedFrames;
	}

	public void setNoOfCustomizedFrames(Long noOfCustomizedFrames) {
		this.noOfCustomizedFrames = noOfCustomizedFrames;
	}

}
