package com.rameshit.login.dao;

import com.rameshit.login.model.LoginModel;

public interface LoginDAO {

	LoginModel getLoginModel(String username);

}
