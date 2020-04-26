package com.csd.authenticator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticateUserTest {
	
	/**
	 * 1. AuthenticateUserService
	 * 2. UserInfo
	 */
	
	UserInfo userInfo, storeduserinfo, falseUserInfo;
	UserDao userDao=mock(UserDao.class);
	AuthenticateUserService authUserService = new AuthenticateUserService(userDao);
	
	
	
	@Before
	public void setup(){
		
		storeduserinfo = new UserInfo();
		storeduserinfo.setUserName("Admin");
		storeduserinfo.setPassword("Admin123");
		when(userDao.getUser_byName()).thenReturn((UserInfo) storeduserinfo);
	}
	
	@After
	public void cleanUp(){
		userInfo = null;
		storeduserinfo= null;
		falseUserInfo = null;
	}
	
	//Case 1 : Return true if user exist;
	@Test
	public void testAuthenticateUser(){
		userInfo = new UserInfo();
		userInfo.setUserName("Admin");
		userInfo.setPassword("Admin123");
		
		boolean actualValue = authUserService.verifyUserInfo(userInfo);
		Mockito.verify(userDao).getUser_byName();
		assertTrue(actualValue);
	}
	//Case 2: Return false if user doesn't exist;
	@Test
	public void testNotAuthenticateUser(){
		falseUserInfo = new UserInfo();
		falseUserInfo.setUserName("administator");
		falseUserInfo.setPassword("1234");
		
		boolean actualValue = authUserService.verifyUserInfo(falseUserInfo);
		Mockito.verify(userDao).getUser_byName();
		assertFalse(actualValue);
	}
	//Case 3: If user info is Null, Return null pointer exception. Test should consume it.
	@Test
	public void testAuthUserIsNull(){
		assertFalse(authUserService.verifyUserInfo(null));
	}
	//Case 4: User Name is correct but password is incorrect, return false;
	@Test
	public void testInCorrectPassword(){
		falseUserInfo = new UserInfo();
		falseUserInfo.setUserName("administator");
		falseUserInfo.setPassword("1234");
		
		when(userDao.getUser_byName()).thenReturn(null);
		boolean actualValue = authUserService.verifyUserInfo(falseUserInfo);
		assertFalse(actualValue);
	}
	//Case 5: Empty Name should now be allowed.
	//Case 6: Username is not case sensitive.
	//Case 7: password should be case sensitive.
	
}

