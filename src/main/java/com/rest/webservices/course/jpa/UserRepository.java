package com.rest.webservices.course.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.webservices.users.Users;

public interface UserRepository extends JpaRepository<Users, String>{

}
