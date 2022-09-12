package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.FarmerCrop;

@Repository
public interface FarmerCropRepository extends JpaRepository<FarmerCrop, Long> {
	
	@Query("select c from FarmerCrop c where c.user.id=?1")
	List<FarmerCrop> getCropFromFarmerId(Long fId);

}
