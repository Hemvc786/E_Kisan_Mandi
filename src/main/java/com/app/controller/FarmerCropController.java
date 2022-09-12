package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FarmerCropDTO;
import com.app.service.IFarmerCropService;

@RestController
@RequestMapping("/api/farmer")
@Validated
public class FarmerCropController {

	@Autowired
	private IFarmerCropService cropService;

	@PostMapping("/{fId}")
	public ResponseEntity<FarmerCropDTO> registerCrop(@PathVariable Long fId, @RequestBody FarmerCropDTO crop) {
		return new ResponseEntity<>(cropService.saveCropDetails(fId, crop), HttpStatus.CREATED);
	}

	// get all crops listed by specific farmer
	@GetMapping("/{fId}")
	public ResponseEntity<?> getAllCropsOfSpecificFarmer(@PathVariable Long fId) {
		List<FarmerCropDTO> list = cropService.getAllCropsDetailsOfSpecificFarmer(fId);
		if (list.isEmpty()) {
			return ResponseEntity.ok("Empty List, No crops have been listed yet..!!!!!!");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	// get all crops listed (for trader)
	@GetMapping
	public ResponseEntity<?> getAllCrops() {
		List<FarmerCropDTO> list = cropService.getAllCropsDetails();
		if (list.isEmpty()) {
			return ResponseEntity.ok("Empty List....!!!!!");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

//	@GetMapping("/{id}")
//	public ResponseEntity<?> getCropById(@PathVariable Long id) {
//		return ResponseEntity.ok(cropService.getCropDetails(id));
//	}

	@DeleteMapping("/{cropId}")
	public String deleteCrop(@PathVariable Long cropId) {
		return cropService.deleteCropDetails(cropId);
	}

	@PutMapping
	public FarmerCropDTO updateCrop(@RequestBody FarmerCropDTO crop) {
		return cropService.updateCropDetails(crop);
	}

}
