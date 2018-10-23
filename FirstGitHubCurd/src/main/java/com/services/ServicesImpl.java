package com.services;

import java.util.List;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.CredentialsDao;
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
	CredentialsDao credentialsDao;
	
	
	@Override
	public int saveUser(User user, Credentials credentials) {

		return 0;
	}


     @Override
	public List<Credentials> login(Credentials credentials) {
		Credentials credentials2=credentialsDao.findAllByUsernameAndPassord(credentials.getUsername(),credentials.getPassword());
		
		
		return null;
		
	}


	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>)userDao.findAll();
	}

}
