package com.app.service;

import java.util.List;

import com.app.pojos.FarmerCrop;

public interface IFarmerCropService {

	//save new crop details
	FarmerCrop saveCropDetails(FarmerCrop crop);
	
	//get all Crops
	List<FarmerCrop> getAllCropsDetails();
	
	//get crop details by specified id
	FarmerCrop getCropDetails(Long cropId);
	
	//delete crop details
	String deleteCropDetails(Long cropId);
	
	//update crop details
	FarmerCrop updateCropDetails(FarmerCrop updatedCrop);
	
	
}
