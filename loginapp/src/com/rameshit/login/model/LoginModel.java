package com.rameshit.login.model;

import java.io.Serializable;

/*
@author Abhilash
This is used to transfer data from one layer to another.
This is called Data Transfer Object or Value Object.
 */

public class LoginModel implements Serializable {

	private static final long serialVersionUID = 1L;

	public LoginModel() {
		System.out.println("LoginModel default constructor...!");
	}

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
