package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.Credentials;

public interface CredentialsDao extends CrudRepository<Credentials, Integer> {
    Credentials findAllByUsernameAndPassord(String username,String password);
}
