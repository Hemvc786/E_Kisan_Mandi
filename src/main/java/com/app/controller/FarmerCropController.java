package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.pojos.FarmerCrop;
import com.app.service.IFarmerCropService;

@Controller
@RequestMapping("/api/farmerCrops")
public class FarmerCropController {
	
	@Autowired
	private IFarmerCropService cropService;
	
	@PostMapping
	public ResponseEntity<FarmerCrop> registerCrop(@RequestBody FarmerCrop crop) {
		return new ResponseEntity<>( cropService.saveCropDetails(crop), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCrops() {
		 List<FarmerCrop> list = cropService.getAllCropsDetails();
		 if(list.isEmpty()) {
			 return ResponseEntity.ok("Empty List....!!!!!");
		 }
		 return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCropById(@PathVariable Long id){
			return ResponseEntity.ok(cropService.getCropDetails(id));
	}
	
	@DeleteMapping("/{id}")
	public String deleteCrop(@PathVariable Long id) {
		return cropService.deleteCropDetails(id);
	}
	
	@PutMapping
	public FarmerCrop updateCrop(@RequestBody FarmerCrop crop) {
		return cropService.updateCropDetails(crop);
	}

}
