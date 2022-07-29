package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bid")
@Getter
@Setter
@NoArgsConstructor
public class Bids extends BaseEntity {

	@Column(name= "bid_amount")
	private Double bidAmount;
	
	@ManyToOne
	@JoinColumn(name = "crop_id")
	private FarmerCrop crop;
	
	@ManyToMany
	@JoinTable(name = "bid_user",
	joinColumns = @JoinColumn(name="bid_id"),inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<User> bidders=new HashSet<>();

	
	public Bids(Double bidAmount) {
		super();
		this.bidAmount = bidAmount;
	}
	
	
}
