package com.rest.webservices.users;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class Users {

	protected Users() {

	}

	@Id
	@GeneratedValue
	private String Id;

	@Size(min = 2, message = "Name should contain min 2 chars")
	@JsonProperty("user_name")
	private String name;

	@Past(message = "Birth Date should be in the past")
	@JsonProperty("birth_date")
	private LocalDate birthdate;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> post;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Users [Id=" + Id + ", name=" + name + ", birthdate=" + birthdate + ", post=" + post + "]";
	}

	public Users(String id, String name, LocalDate birthdate) {
		super();
		Id = id;
		this.name = name;
		this.birthdate = birthdate;

	}

}
