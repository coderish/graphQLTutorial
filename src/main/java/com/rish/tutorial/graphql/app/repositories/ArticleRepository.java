package com.rish.tutorial.graphql.app.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rish.tutorial.graphql.app.models.Article;

@Repository
public interface ArticleRepository extends MongoRepository<Article, ObjectId> {

}
