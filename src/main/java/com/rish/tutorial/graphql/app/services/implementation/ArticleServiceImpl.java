package com.rish.tutorial.graphql.app.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rish.tutorial.graphql.app.models.Article;
import com.rish.tutorial.graphql.app.repositories.ArticleRepository;
import com.rish.tutorial.graphql.app.services.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	@Override
	public List<Article> findAllUserArticles(Iterable articleIds) {
		return (List<Article>) articleRepository.findAll(articleIds);
	}

}
