package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "adr_tbl")
@Getter
@Setter
@NoArgsConstructor
public class Address extends BaseEntity {
	
	@Column(length = 30)
	private String tehsil;
	@Column(length = 30)
	private String district;
	@Column(length = 30)
	private String state;
	@Column(length = 30)
	private String country;
	
	@OneToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable = false) //nullable is optional but recommended to use in onetoOne uni-directional case
	@MapsId 
	private User user;

	public Address(String tehsil, String district, String state, String country) {
		super();
		this.tehsil = tehsil;
		this.district = district;
		this.state = state;
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Address [tehsil=" + tehsil + ", district=" + district + ", state=" + state + ", country=" + country
				+ "]";
	}

	
}
