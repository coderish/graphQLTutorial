package com.rish.tutorial.graphql.app.dataFetchers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rish.tutorial.graphql.app.models.User;
import com.rish.tutorial.graphql.app.services.UserService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllUsersDataFetcher implements DataFetcher<List<User>> {

	private final UserService userService;

	@Autowired
	AllUsersDataFetcher(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> get(DataFetchingEnvironment env) {
		User user = env.getSource();
		List<User> friends = new ArrayList<>();
		if (user != null) {
			friends = userService.findByIdIn(user.getFriendsIds());
		} else {
			friends = userService.findAllUsers();
		}
		return friends;
	}
}
