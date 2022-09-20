package com.app.dto;

import javax.validation.constraints.NotEmpty;

import com.app.pojos.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class BidsDTO extends BaseEntity {
	
	@NotEmpty(message = "Bid amount must be supplied")
	private Double bidAmount;
	
}
