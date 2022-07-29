package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
@NoArgsConstructor
public class Review extends BaseEntity {
	
	
	private String reviewMesg;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "crop_id")
	private FarmerCrop crop;

	public Review(String reviewMesg) {
		super();
		this.reviewMesg = reviewMesg;
	}
	
}
