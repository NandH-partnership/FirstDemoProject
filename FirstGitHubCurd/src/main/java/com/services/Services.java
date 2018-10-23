package com.services;

import java.util.List;

import com.model.Credentials;
import com.model.User;

public interface Services {

	int saveUser(User user, Credentials credentials);
	List<Credentials> login(Credentials credentials);
	List<User> getAllUser();

}
