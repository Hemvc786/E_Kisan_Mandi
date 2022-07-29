package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BidsRepository;
import com.app.pojos.Bids;

@Service
@Transactional
public class BidsServiceImpl implements IBidsService {

	@Autowired
	private BidsRepository bidRepo;
	
	@Override
	public Bids saveBidDetails(Bids bid) {
		return bidRepo.save(bid);
	}

	@Override
	public List<Bids> getAllBidsDetails() {
		
		return null;
	}

	@Override
	public Bids getBidDetails(Long bidId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBidDetails(Long bidId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bids updateBidDetails(Bids updatedBid) {
		// TODO Auto-generated method stub
		return null;
	}

}
