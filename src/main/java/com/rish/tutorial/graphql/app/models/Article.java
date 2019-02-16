package com.rish.tutorial.graphql.app.models;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "articles")
public class Article implements Serializable {

	private static final long serialVersionUID = 3147716128499664554L;

	@Id
	private ObjectId id;
	private String title;
	private Integer minutesRead;
	private String authorId;

	public Article() {
	}

	public Article(String title, Integer minutesRead, String authorId) {
		super();
		this.title = title;
		this.minutesRead = minutesRead;
		this.authorId = authorId;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMinutesRead() {
		return minutesRead;
	}

	public void setMinutesRead(Integer minutesRead) {
		this.minutesRead = minutesRead;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", minutesRead=" + minutesRead + ", authorId=" + authorId
				+ "]";
	}

}
