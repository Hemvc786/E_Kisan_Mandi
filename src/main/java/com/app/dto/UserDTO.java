package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.pojos.AdharCard;
import com.app.pojos.BaseEntity;
import com.app.pojos.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO extends BaseEntity{

		@NotEmpty(message = "First name must be supplied")
		private String firstName;
		
		@NotEmpty(message = "Last name must be supplied")
		private String lastName;
		
		@NotEmpty(message = "Email must be supplied")
		@Length(min=5,max=20)
		@Email
		private String email;
		
		@JsonProperty(access = Access.WRITE_ONLY) //for de-serialization only=>password won't be serialized to json
		@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
		private String password;
		
		@NotEmpty(message = "Contact no must be supplied")
		@Length(min = 0,max=10,message = "Invalid contact no")
		private String contactNo;
		
		@NotNull
		private Role role;
		
		@NotNull(message = "Adhar Card Details must be supplied")
		private AdharCard card;

}
