package com.rameshit.login.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.rameshit.login.dao.LoginDAO;
import com.rameshit.login.model.LoginModel;

@Repository(value = "loginDAO")
public class LoginDAOImpl implements LoginDAO {

	public LoginDAOImpl() {
		System.out.println("In LoginDAOImpl Constructor..!");
	}

	private static final String GET_LOGIN_INFO = "select username, password from users where username=?";

	@Override
	public LoginModel getLoginModel(String userName) {
		System.out.println("Begin:getLoginModel in DAO");

		System.out.println("Getting LoginInformation for UserName: " + userName);

		LoginModel loginModel = null;
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatementent = connection.prepareStatement(GET_LOGIN_INFO);
			preparedStatementent.setString(1, userName);

			ResultSet resultSet = preparedStatementent.executeQuery();

			while (resultSet.next()) {
				loginModel = new LoginModel();
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				loginModel.setUsername(username);
				loginModel.setPassword(password);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End:getLoginModel() in DAO");
		return loginModel;
	}

	private Connection getConnection() throws SQLException, ClassNotFoundException {

		System.out.println("getting connection");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "oracledb",
				"password");
		System.out.println("Connection: " + connection);
		return connection;
	}

}
