package com.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.RoleDao;
import com.dao.UserDao;
import com.model.Credentials;
import com.model.User;

public class ServicesImpl implements Services {

	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	Credentials credentials;
	
	
	@Override
	public int saveUser(User user, Credentials credentials) {

		return 0;
	}

}
