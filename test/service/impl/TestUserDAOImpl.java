package service.impl;

import org.junit.Test;

import entity.Users;
import junit.framework.Assert;
import service.UserDAO;

public class TestUserDAOImpl {
	
	@Test
	public void testUsersLogin( ) {
		Users users = new Users(1,"zhangsan","123");
		UserDAO uDao = new UsersDAOImpl();
		Assert.assertEquals(true, uDao.usersLongin(users));
		
	}
}
