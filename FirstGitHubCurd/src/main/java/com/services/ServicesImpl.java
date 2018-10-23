package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CredentialsDao;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.model.Credentials;
import com.model.User;

@Service
public class ServicesImpl implements Services {

	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	CredentialsDao credentials;
	
	
	@Override
	public int saveUser(User user, Credentials credentials) {
		user.setCredentials(credentials);
		try
		{
		userDao.save(user);
		return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
