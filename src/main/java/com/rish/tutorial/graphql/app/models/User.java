package com.rish.tutorial.graphql.app.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Document(collection = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1912059917616988111L;

	@Id
	private ObjectId id;

	private String name;
	private Integer age;
	private Date createdAt;
	private String nationality;
	private List<String> friendsIds;
	private List<String> articlesIds;

	public User() {
	}

	public User(String name, Integer age, Date createdAt, String nationality, List<String> friendsIds,
			List<String> articlesIds) {
		super();
		this.name = name;
		this.age = age;
		this.createdAt = createdAt;
		this.nationality = nationality;
		this.friendsIds = friendsIds;
		this.articlesIds = articlesIds;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public List<String> getFriendsIds() {
		return friendsIds;
	}

	public void setFriendsIds(List<String> friendsIds) {
		this.friendsIds = friendsIds;
	}

	public List<String> getArticlesIds() {
		return articlesIds;
	}

	public void setArticlesIds(List<String> articlesIds) {
		this.articlesIds = articlesIds;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", createdAt=" + createdAt + ", nationality="
				+ nationality + ", friendsIds=" + friendsIds + ", articlesIds=" + articlesIds + "]";
	}

}
