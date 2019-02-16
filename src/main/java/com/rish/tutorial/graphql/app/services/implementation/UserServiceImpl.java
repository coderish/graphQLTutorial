package com.rish.tutorial.graphql.app.services.implementation;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rish.tutorial.graphql.app.models.User;
import com.rish.tutorial.graphql.app.repositories.UserRepository;
import com.rish.tutorial.graphql.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findByIdIn(Iterable friendsUserId) {
		return (List<User>) userRepository.findAll(friendsUserId);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findOneById(ObjectId objectId) {
		return userRepository.findOne(objectId);
	}

}
