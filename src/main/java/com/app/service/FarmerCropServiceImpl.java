package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BidsRepository;
import com.app.dao.FarmerCropRepository;
import com.app.dao.UserRepository;
import com.app.dto.FarmerCropDTO;
import com.app.dto.UserDTO;
import com.app.pojos.FarmerCrop;
import com.app.pojos.User;

@Service
@Transactional
public class FarmerCropServiceImpl implements IFarmerCropService {

	@Autowired
	private FarmerCropRepository farmerCropRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BidsRepository bidRepo;

	@Override
	public FarmerCropDTO saveCropDetails(Long fId, FarmerCropDTO cropDto) {
		FarmerCrop crop = mapper.map(cropDto, FarmerCrop.class);
		User user = userRepo.getById(fId);
		//findById(fId).orElseThrow(() -> new ResourceNotFoundException("Farmer Not Exists..!!!!!"));//findBy will fire select query on users table
		crop.setUser(user);
		return mapper.map(farmerCropRepo.save(crop), FarmerCropDTO.class);
	}

	// get all Crops for trader
	@Override
	public List<FarmerCropDTO> getAllCropsDetails() {
		List<FarmerCrop> list = farmerCropRepo.findAll();
		List<FarmerCropDTO> cropDtoList = new ArrayList<>();
		for (FarmerCrop c : list) {
			cropDtoList.add(mapper.map(c, FarmerCropDTO.class));
		}
		return cropDtoList;
	}

	// get all Crops of specific farmer
	@Override
	public List<FarmerCropDTO> getAllCropsDetailsOfSpecificFarmer(Long fId) {
		userRepo.findById(fId).orElseThrow(() -> new ResourceNotFoundException("Farmer Not Exists..!!!!!"));
		// if farmer not exits it will show suitable msg(hence we use findBy instead of getBy)

		// =>farmer exits
		List<FarmerCrop> list = farmerCropRepo.getCropFromFarmerId(fId);
		List<FarmerCropDTO> cropDtoList = new ArrayList<>();
		for (FarmerCrop c : list) {
			cropDtoList.add(mapper.map(c, FarmerCropDTO.class));
		}
		return cropDtoList;
	}

	@Override
	public FarmerCropDTO getCropDetails(Long cropId) {
		FarmerCrop crop = farmerCropRepo.findById(cropId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Crop Id " + cropId));

		return mapper.map(crop, FarmerCropDTO.class);
	}

	//delete crop by farmer only
	@Override
	public String deleteCropDetails(Long cropId) {
		String mesg = "Deletion of Crop details failed.!!!!!!!!";
		
		if (farmerCropRepo.existsById(cropId)) {
			bidRepo.deleteBidByCropId(cropId);
			farmerCropRepo.deleteById(cropId);
			mesg = "Crop details deleted successfully , for crop id : " + cropId;
		}
		return mesg;
	}

	@Override
	public FarmerCropDTO updateCropDetails(Long fId,FarmerCropDTO updatedCrop) {
		User user = userRepo.getById(fId);
		FarmerCrop crop = mapper.map(updatedCrop, FarmerCrop.class);
		crop.setUser(user);
		return mapper.map(farmerCropRepo.save(crop), FarmerCropDTO.class);
	}

	@Override
	public List<FarmerCropDTO> getAllCropsByName(String name) {
		List<FarmerCrop> crops = farmerCropRepo.getCropFromCropName(name);
		List<FarmerCropDTO> cropDtoList = new ArrayList<>();
		for (FarmerCrop c : crops) {
			cropDtoList.add(mapper.map(c, FarmerCropDTO.class));
		}
		return cropDtoList;
	}

	@Override
	public UserDTO getFarmerByCropId(Long cropId) {
		FarmerCrop crop = farmerCropRepo.getById(cropId);
		return mapper.map(crop.getUser(), UserDTO.class);
	}

}
