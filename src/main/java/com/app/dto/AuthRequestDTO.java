package com.app.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthRequestDTO {
	
	@NotEmpty(message = "Email must be supplied")
	private String email;
	
	@NotEmpty(message = "Password must be supplied")
	private String password;

}
