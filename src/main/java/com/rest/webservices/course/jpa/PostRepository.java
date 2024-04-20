package com.rest.webservices.course.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.users.Post;

public interface PostRepository extends JpaRepository<Post, String>{

}
