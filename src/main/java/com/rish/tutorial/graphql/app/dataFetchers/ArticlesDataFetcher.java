package com.rish.tutorial.graphql.app.dataFetchers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rish.tutorial.graphql.app.models.Article;
import com.rish.tutorial.graphql.app.models.User;
import com.rish.tutorial.graphql.app.services.ArticleService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ArticlesDataFetcher implements DataFetcher<List<Article>>{

    private final ArticleService articleService;

    @Autowired
    ArticlesDataFetcher(ArticleService articleService){
        this.articleService = articleService;
    }

    @Override
    public List<Article> get(DataFetchingEnvironment env) {
        User user = env.getSource();
        List<String> articleIds = new ArrayList<>();
        if(user!=null){
            articleIds = user.getArticlesIds();
        }
        List<Article> articles = articleService.findAllUserArticles(articleIds);
        return articles;
    }
}