package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

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
	
	@NotEmpty(message = "First name must be supplied")
	@Column(length = 30,name = "first_name")
	private String firstName;
	@NotEmpty(message = "Last name must be supplied")
	@Column(length = 30,name = "last_name")
	private String lastName;
	@Length(min = 4,max=30,message = "Invalid user name length")
	@Column(length = 30)
	private String userName;
	@Column(length = 30)
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	private String password;
	private Long contactNo;
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	@Embedded
	private AdharCard card;

}
