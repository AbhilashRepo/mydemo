package com.rameshit.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rameshit.login.dao.LoginDAO;
import com.rameshit.login.model.LoginModel;
import com.rameshit.login.service.LoginService;

@Service(value="loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public LoginServiceImpl() {
		 System.out.println("In LoginServiceImpl Constructor...!");
	}

	@Override
	public boolean isValidLoginDetials(LoginModel loginModel) {
		
		System.out.println("Begin: isValidLoginDetials in Service");
		
		boolean returnValue = false;
		
		
		String username = loginModel.getUsername();
		String password = loginModel.getPassword();
		
		String dbUserName = null;
		String dbPassWord = null;

		LoginModel dbLoginModel = loginDAO.getLoginModel(username);
		
		if (dbLoginModel != null) {
			dbUserName = dbLoginModel.getUsername();
			dbPassWord = dbLoginModel.getPassword();
		}
		if (username != null && dbUserName != null && password != null && dbPassWord != null) {
			if (username.equals(dbUserName) && password.equals(dbPassWord)) {
				returnValue = true;
			}
		}
		System.out.println("End: isValidLoginDetials in Service");
		return returnValue;
	}

}
