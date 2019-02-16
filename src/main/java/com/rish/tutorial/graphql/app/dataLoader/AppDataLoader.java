package com.rish.tutorial.graphql.app.dataLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rish.tutorial.graphql.app.models.Article;
import com.rish.tutorial.graphql.app.models.User;
import com.rish.tutorial.graphql.app.repositories.ArticleRepository;
import com.rish.tutorial.graphql.app.repositories.UserRepository;

@Component
public class AppDataLoader {

	private final UserRepository userRepository;
	private final ArticleRepository articleRepository;

	@Autowired
	public AppDataLoader(UserRepository userRepository, ArticleRepository articleRepository) {
		this.userRepository = userRepository;
		this.articleRepository = articleRepository;
	}

//	@PostConstruct
	private void generateData() {
		List<User> users = new ArrayList<>();
		users.add(new User("Igor", 24, new Date(), null, new ArrayList<String>(), new ArrayList<String>()));
		users.add(new User("Ellen", 24, new Date(), null, new ArrayList<String>(), new ArrayList<String>()));
		users.add(new User("John", 53, new Date(), null, new ArrayList<String>(), new ArrayList<String>()));
		users.add(new User("Nazar", 14, new Date(), null, new ArrayList<String>(), new ArrayList<String>()));
		users = userRepository.save(users);

		List<Article> articles = new ArrayList<>();
		articles.add(new Article("Java 8 Lambdas", 8, users.get(0).getId().toString()));
		articles.add(new Article("GraphQL Getting Started", 10, users.get(1).getId().toString()));
		articles.add(new Article("Spring Boot + WebSockets", 16, users.get(3).getId().toString()));
		articles = articleRepository.save(articles);

		users.get(0).setArticlesIds(Arrays.asList(articles.get(0).getId().toHexString()));
		users.get(0).setArticlesIds(Arrays.asList(articles.get(1).getId().toHexString()));
		users.get(1).setArticlesIds(Arrays.asList(articles.get(2).getId().toHexString()));
		users.get(3).setArticlesIds(Arrays.asList(articles.get(0).getId().toHexString()));

		userRepository.save(users);

		User me = users.get(0);
		List<String> myFriendsIds = new ArrayList<>();
		for (int i = 1; i < users.size(); i++) {
			myFriendsIds.add(users.get(i).getId().toHexString());
		}
		me.setFriendsIds(myFriendsIds);
		userRepository.save(me);

	}
}
