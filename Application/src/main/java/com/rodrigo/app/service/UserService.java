package com.rodrigo.app.service;

import com.rodrigo.app.entity.User;

public interface UserService {
	public Iterable<User> getAllUsers();
	public User createUser(User formUser) throws Exception;
	public User getUserById(Long id) throws Exception;
	public User updateUser(User user) throws Exception;
}
