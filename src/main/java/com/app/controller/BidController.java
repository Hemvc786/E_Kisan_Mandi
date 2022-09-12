package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BidsDTO;
import com.app.service.IBidsService;

@RestController
@RequestMapping("/api/crops")
@Validated
public class BidController {
	@Autowired
	private IBidsService bidService;

	@GetMapping
	public ResponseEntity<?> showAllBids() {
		List<BidsDTO> list = bidService.getAllBidsDetails();
		if (list.isEmpty()) {
			return ResponseEntity.ok("No Bids yet...!!!");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{cropId}")
	public ResponseEntity<?> showAllBidFromCropid(@PathVariable Long cropId){
		List<BidsDTO> list = bidService.getAllBidsFromCropId(cropId);
		if (list.isEmpty()) {
			return ResponseEntity.ok("No Bids yet...!!!");
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("/{userId}/{cropId}")
	public ResponseEntity<BidsDTO> AddBid(@PathVariable Long userId, @PathVariable Long cropId, @RequestBody BidsDTO bidDto) {
		
		return new ResponseEntity<>(bidService.saveBidDetails(bidDto, cropId, userId), HttpStatus.CREATED);
	}

}
