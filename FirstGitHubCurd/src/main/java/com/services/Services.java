package com.services;

import java.util.List;

import org.springframework.ui.Model;

import com.model.Credentials;
import com.model.User;

public interface Services {

	int saveUser(User user, Credentials credentials, int roleid);

	User getSingleUser(Credentials credentials);

	void getDataForMangerPage(User user, Model model);

	

	


}
