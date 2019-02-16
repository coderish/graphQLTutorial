package com.rish.tutorial.graphql.app.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.rish.tutorial.graphql.app.models.User;

public interface UserService {

	List<User> findByIdIn(Iterable friendsUserId);

	List<User> findAllUsers();
	
	User findOneById(ObjectId objectId);
}
