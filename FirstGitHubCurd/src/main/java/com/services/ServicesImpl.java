package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<User> getListByRoleId(int i) {
		List<User>allList=(List<User>) userDao.findAll();
		List<User>userList=new ArrayList<User>();
		for(User user:allList) {
			if(user.getRole().getRoleid()==i) {
			userList.add(user);
			}
		}
		return userList;
	}


	@Override
	public User getSingleUser(int id) {
		
		return userDao.findOne(id);
	}


	@Override
	public void updateUser(User user) {
		
		Credentials credential=credentialsDao.findAllByUsernameAndPassword(user.getCredentials().getUsername(), user.getCredentials().getPassword());
		System.out.println("in service"+credential.getLoginid());
		
		/*user.setCredentials(credential);
		userDao.save(user);*/
		
	}


	@Override
	public int removeUser(int id) {
		try {
		User user=userDao.findOne(id);
		user.setRole(null);
		userDao.delete(id);
		return 1;
		}catch (Exception e) {
			System.out.println("Exception in SI while Remove");
			e.printStackTrace();
		}
		
		
		return 0;
	}




	


  


	

}
