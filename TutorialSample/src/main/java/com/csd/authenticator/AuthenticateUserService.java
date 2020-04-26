package com.csd.authenticator;

import java.sql.SQLException;

public class AuthenticateUserService {

	UserDao userDao;
	public AuthenticateUserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean verifyUserInfo(UserInfo userInfo) {
		UserInfo user;
		try {
		
			user = userDao.getUser_byName();
			String key = user.getUserName()+user.getPassword();
			if(userInfo!=null && key.equals(userInfo.getUserName()+userInfo.getPassword()))
				return true;
			return false;

		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
