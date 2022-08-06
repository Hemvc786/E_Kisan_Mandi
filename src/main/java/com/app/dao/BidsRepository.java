package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Bids;

public interface BidsRepository extends JpaRepository<Bids, Long> {
	
	@Query("select b from Bids b where b.crop.id=?1")
	List<Bids> BidsFromCropId(Long cropId);

}
