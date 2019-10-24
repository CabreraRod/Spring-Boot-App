package com.rodrigo.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.rodrigo.app.entity.User;
import com.rodrigo.app.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public boolean checkUsernameAvailable(User user) throws Exception{
		Optional<User> userFound = userRepository.findByUsername(user.getUsername());
		if(userFound.isPresent()) {
			throw new Exception ("Username no disponible");
		}
		return true;
	}
	private boolean checkPasswordValid(User user) throws Exception{
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception ("Password y confirm Password no son iguales");
		}
		return true;
	}
	
	@Override
	public User createUser(User user) throws Exception{
		if(checkUsernameAvailable(user)&& checkPasswordValid(user)) {
			user = userRepository.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		User user = userRepository.findById(id).orElseThrow(() -> new Exception("User does not exist"));
		return user;
	}

	@Override
	public User updateUser(User fromUser) throws Exception {
		User toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return userRepository.save(toUser);
	}
	
	protected void mapUser(User from, User to) {
		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}
	
}
