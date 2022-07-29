package com.app.service;

import java.util.List;

import com.app.pojos.Bids;

public interface IBidsService {
	
		//save new Bid details
		Bids saveBidDetails(Bids bid);
		
		//get all Bids
		List<Bids> getAllBidsDetails();
		
		//get bid details by specified id
		Bids getBidDetails(Long bidId);
		
		//delete bid details
		String deleteBidDetails(Long bidId);
		
		//update bid details
		Bids updateBidDetails(Bids updatedBid);

}
