package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.app.pojos.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FarmerCropDTO extends BaseEntity {

	@NotEmpty(message = "Crop name must be supplied")
	private String cropName;
	
	@NotEmpty(message = "Species must be supplied")
	private String species;

	@NotEmpty(message = "Grade must be supplied")
	private String grade;
	
	@Past(message = "sowing date must be in the past")
	private LocalDate sowingDate;
	
	private LocalDate harvestDate;
	@NotNull(message = "Quantity must be supplied")
	private Double quantity;
	private String photos;
	
	@NotNull(message = "Least price must be supplied")
	private Double leastPrice;
	@NotNull(message = "Status Details must be supplied")
	private boolean status;

	
}
