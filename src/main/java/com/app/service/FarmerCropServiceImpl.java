package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.FarmerCropRepository;
import com.app.pojos.FarmerCrop;

@Service
@Transactional
public class FarmerCropServiceImpl implements IFarmerCropService {
	
	@Autowired
	private FarmerCropRepository farmerCropRepo;

	@Override
	public FarmerCrop saveCropDetails(FarmerCrop crop) {
		return farmerCropRepo.save(crop);
	}

	@Override
	public List<FarmerCrop> getAllCropsDetails() {
		return farmerCropRepo.findAll();
	}

	@Override
	public FarmerCrop getCropDetails(Long cropId) {
		return farmerCropRepo.findById(cropId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Crop Id "+cropId));
	}

	@Override
	public String deleteCropDetails(Long cropId) {
		String mesg = "Deletion of Crop details failed.!!!!!!!!";
		
		if(farmerCropRepo.existsById(cropId)) {
			farmerCropRepo.deleteById(cropId);
			mesg = "Crop details deleted successfully , for crop id : " + cropId;
		}
		return mesg;
	}

	@Override
	public FarmerCrop updateCropDetails(FarmerCrop updatedCrop) {
		return farmerCropRepo.save(updatedCrop);
	}

}
