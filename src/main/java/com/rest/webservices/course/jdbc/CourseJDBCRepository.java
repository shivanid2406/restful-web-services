package com.rest.webservices.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rest.webservices.course.Course;

@Repository
public class CourseJDBCRepository {

	@Autowired
	private JdbcTemplate springjdbcTemplate;

	private static String INSERT_QUERY = """
			insert into course(id,name,author)
			values(?,?,?)
			""";
	private static String DELETE_QUERY = """
			delete from course where id=?
			""";
	private static String SELECT_QUERY = """
			select * from course id=?
			""";

	public void insert(Course course) {

		springjdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long Id) {

		springjdbcTemplate.update(DELETE_QUERY, Id);
	}

	public Course findById(long Id) {

		return springjdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), Id);
	}
}

//create table course(id bigint not null,name varchar(255) not null,author varchar(255) not null,primary key(id));
