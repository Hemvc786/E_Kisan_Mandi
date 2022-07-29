package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.FarmerCrop;

public interface FarmerCropRepository extends JpaRepository<FarmerCrop, Long> {

}
