package com.app.service;

import java.util.List;

import com.app.dto.BidsDTO;
import com.app.pojos.Bids;

public interface IBidsService {
	
		//save new Bid details
		BidsDTO saveBidDetails(BidsDTO bidDto,Long cropId, Long userId);
		
		//get all Bids
		List<BidsDTO> getAllBidsDetails();
		
		//get bids from crop id
		List<BidsDTO> getAllBidsFromCropId(Long cropId);
		
		//get bid details by specified id
		Bids getBidDetails(Long bidId);
		
		//delete bid details
		String deleteBidDetails(Long bidId);
		
		//update bid details
		Bids updateBidDetails(Bids updatedBid);

}
