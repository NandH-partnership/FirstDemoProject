package com.services;

import com.model.Credentials;
import com.model.User;

public interface Services {

	int saveUser(User user, Credentials credentials);

}
