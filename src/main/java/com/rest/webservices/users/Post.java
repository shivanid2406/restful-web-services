package com.rest.webservices.users;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer Id;

	@Size(min = 10)
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Users user;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [Id=" + Id + ", description=" + description + ", user=" + user + "]";
	}

}

/*
 * insert into post(id,description,user_id)
 * values(1,"Learning Spring Boot,246"); insert into
 * post(id,description,user_id) values(1,"Learning Spring MVC,123"); insert into
 * post(id,description,user_id) values(1,"Learning Spring Data JPA,789");
 */
