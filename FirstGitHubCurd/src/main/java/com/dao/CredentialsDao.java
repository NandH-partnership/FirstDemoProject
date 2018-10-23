package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.Credentials;

public interface CredentialsDao extends CrudRepository<Credentials, Integer> {
    Credentials findAllByUsernameAndPassword(String username,String password);
}
