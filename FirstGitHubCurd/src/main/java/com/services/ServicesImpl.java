package com.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.CredentialsDao;
import com.dao.RoleDao;
import com.dao.UserDao;
import com.model.Credentials;
import com.model.Role;
import com.model.User;

@Service
public class ServicesImpl implements Services {

	@Autowired
	UserDao userDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	CredentialsDao credentialsDao;
	
	List<User>userList=new ArrayList<User>();
	List<User>managerList=new ArrayList<User>();
	@Override
	public int saveUser(User user, Credentials credentials,int roleid) {
		Role role=roleDao.findOne(roleid);
		user.setRole(role);
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


	@Override
	public User getSingleUser(Credentials credential) {
		
		credential=credentialsDao.findAllByUsernameAndPassword(credential.getUsername(), credential.getPassword());
		
		
		return userDao.findOneByCredentials(credential);
	}


	@Override
	public void getDataForMangerPage(User user, Model model) {
		List<User>allList=(List<User>) userDao.findAll();
		
		
		
	}


  


	

}
