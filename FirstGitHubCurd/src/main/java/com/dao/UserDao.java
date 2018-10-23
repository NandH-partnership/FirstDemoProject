package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.User;

public interface UserDao extends CrudRepository<User, Integer>{

}
