package com.app.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.app.pojos.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressDTO  extends BaseEntity{

	@NotEmpty(message = "location must be supplied")
	private String location;
	
	@NotEmpty(message = "tehsil must be supplied")
	private String tehsil;
	
	@NotEmpty(message = "district must be supplied")
	private String district;
	
	@NotEmpty(message = "state must be supplied")
	private String state;
	
	@NotEmpty(message = "country must be supplied")
	private String country;
	
	@NotEmpty(message = "Pin code name must be supplied")
	@Length(min = 0,max=6,message = "Invalid pin code")
	private String pinCode;
	
}
