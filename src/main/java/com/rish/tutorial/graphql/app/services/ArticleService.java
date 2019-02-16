package com.rish.tutorial.graphql.app.services;

import java.util.List;

import com.rish.tutorial.graphql.app.models.Article;

public interface ArticleService {

	List<Article> findAllUserArticles(Iterable articleIds);
}
