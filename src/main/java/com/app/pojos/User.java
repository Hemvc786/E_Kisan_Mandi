package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude ="password")
public class User extends BaseEntity {
	
	
	@Column(length = 30,name = "first_name")
	private String firstName;
	
	@Column(length = 30,name = "last_name")
	private String lastName;
	
	@Column(length = 30)
	private String userName;
	
	@Column(length = 30)
	private String password;
	
	@Column(length = 10)
	private String contactNo;
	
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	@Embedded
	private AdharCard card;

}
