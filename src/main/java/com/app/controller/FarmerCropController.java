package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.FarmerCropDTO;
import com.app.dto.UserDTO;
import com.app.service.IFarmerCropService;

@RestController
@RequestMapping("/api/farmer")
@Validated
@CrossOrigin
public class FarmerCropController {

	@Autowired
	private IFarmerCropService cropService;

	@PostMapping("/{fId}")
	public ResponseEntity<FarmerCropDTO> registerCrop(@PathVariable Long fId, @RequestBody FarmerCropDTO crop) {
		return new ResponseEntity<>(cropService.saveCropDetails(fId, crop), HttpStatus.CREATED);
	}

	// get all crops listed by specific farmer
	@GetMapping("/{fId}/crops")
	public ResponseEntity<?> getAllCropsOfSpecificFarmer(@PathVariable Long fId) {
		List<FarmerCropDTO> list = cropService.getAllCropsDetailsOfSpecificFarmer(fId);
		if (list.isEmpty()) {
			return ResponseEntity.ok(null);
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

	@GetMapping("/crops/{cropid}")
	public ResponseEntity<?> getCropById(@PathVariable Long cropid) {
		return ResponseEntity.ok(cropService.getCropDetails(cropid));
	}

	@DeleteMapping("/crops/{cropId}")
	public String deleteCrop(@PathVariable Long cropId) {
		return cropService.deleteCropDetails(cropId);
	}

	@PutMapping("/{fId}")
	public FarmerCropDTO updateCrop(@PathVariable Long fId, @RequestBody FarmerCropDTO crop) {
		return cropService.updateCropDetails(fId, crop);
	}

	// get all crops by crop name
	@GetMapping("/crops/{cName}/list")
	public ResponseEntity<?> getAllCropsByCropName(@PathVariable String cName) {
		List<FarmerCropDTO> list = cropService.getAllCropsByName(cName);
		if (list.isEmpty()) {
			return ResponseEntity.ok(null);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	//get farmer from crop id
	@GetMapping("/crops/{cropId}/user")
	public UserDTO getFarmerFromCropId(@PathVariable Long cropId) {
		return cropService.getFarmerByCropId(cropId);
	}

}
