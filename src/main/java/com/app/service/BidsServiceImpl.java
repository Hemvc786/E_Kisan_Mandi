package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BidsRepository;
import com.app.dao.FarmerCropRepository;
import com.app.dao.UserRepository;
import com.app.dto.BidsDTO;
import com.app.pojos.Bids;
import com.app.pojos.FarmerCrop;
import com.app.pojos.User;

@Service
@Transactional
public class BidsServiceImpl implements IBidsService {

	@Autowired
	private BidsRepository bidRepo;
	
	@Autowired
	private FarmerCropRepository cropRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public BidsDTO saveBidDetails(BidsDTO bidDto ,Long cropId, Long userId) {
		Bids bid = mapper.map(bidDto, Bids.class);
		User trader = userRepo.getById(userId);
		FarmerCrop crop = cropRepo.getById(cropId);
		bid.getBidders().add(trader);
		bid.setCrop(crop);
		return mapper.map(bidRepo.save(bid), BidsDTO.class);
	}

	@Override
	public List<BidsDTO> getAllBidsDetails() {
		List<Bids> list = bidRepo.findAll();
		List<BidsDTO> BidsDtoList=new ArrayList<>();
		for(Bids b:list) {
			BidsDtoList.add(mapper.map(b, BidsDTO.class));
		}
		return BidsDtoList;
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

	@Override
	public List<BidsDTO> getAllBidsFromCropId(Long cropId) {
		List<Bids> list = bidRepo.BidsFromCropId(cropId);
		List<BidsDTO> BidsDtoList=new ArrayList<>();
		for(Bids b:list) {
			BidsDtoList.add(mapper.map(b, BidsDTO.class));
		}
		return BidsDtoList;
	}

}
