package com.rodrigo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.rodrigo.app.entity.User;
import com.rodrigo.app.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;
	
	public Iterable<User> getAllUsers(){
		
		return repository.findAll();
	
	}

}
