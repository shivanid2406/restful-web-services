package com.rest.webservices.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rest.webservices.course.springdatajpa.CourseSpringDataJPARepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	// @Autowired
	// private CourseJDBCRepository repository;

	// @Autowired
	// private CourseJPARepository repository;

	@Autowired
	private CourseSpringDataJPARepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		repository.save(new Course(1, "Learn AWS JPA", "Shivani"));
		repository.save(new Course(2, "Learn DeOps JPA", "Joey"));
		repository.save(new Course(3, "Learn Linux JPA", "Atharva"));

		repository.deleteById(1l);

		System.out.println(repository.findById(2l));
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		System.out.println(repository.findByAuthor("Joey"));
		System.out.println(repository.findByName("Learn DevOps JPA"));

	}

}
