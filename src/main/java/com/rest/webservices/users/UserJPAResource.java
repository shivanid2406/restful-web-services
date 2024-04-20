package com.rest.webservices.users;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservices.course.jpa.PostRepository;
import com.rest.webservices.course.jpa.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class UserJPAResource {

	private UserRepository userRepository;
	private PostRepository postRepository;

	public UserJPAResource(UserRepository userRepository, PostRepository postRepository) {
		super();
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}

	// GET /users
	@GetMapping("/jpa/users")
	public List<Users> RetrieveAllUsers() {
		return userRepository.findAll();
	}

	// GET /users/{id}
	// https://localhost8080/users
	// EntityModel
	// WebMVCLinkBuilder

	@GetMapping("/jpa/users/{id}")
	public EntityModel<Users> retrieveUser(@PathVariable String Id) {

		Optional<Users> user = userRepository.findById(Id);
		if (user.isEmpty())
			throw new UserNotFoundException("Id:" + Id);
		EntityModel<Users> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methoOn(this.getClass()).RetrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}

	private WebMvcLinkBuilder linkTo(List<Users> retrieveAllUsers) {
		// TODO Auto-generated method stub
		return null;
	}

	private UserJPAResource methoOn(Class<? extends UserJPAResource> class1) {
		// TODO Auto-generated method stub
		return null;
	}

	// Delete /users/{id}
	@DeleteMapping("/jpa/users/{Id}")
	public void deleteUSer(@PathVariable String Id) {
		userRepository.deleteById(Id);
	}

	// GET API to retrieve all posts of a user /users/{id}
	@GetMapping("/jpa/users/{Id}/posts")
	public List<Post> retrievePostForUser(@PathVariable String Id) {
		Optional<Users> user = userRepository.findById(Id);
		if (user.isEmpty())
			throw new UserNotFoundException("Id:" + Id);
		return user.get().getPost();
	}

	// POST /users
	/*
	 * @PostMapping("/jpa/users") public ResponseEntity<Users>
	 * createUser(@Valid @RequestBody Users user){ Users savedUser =
	 * userRepository.save(user); //location - /users/4 => /users/{Id}, users.getId
	 * String location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand
	 * (savedUser.getId()) .toUriString(); return
	 * ResponseEntity.created(location).build(); }
	 */
	//Create a Post for a User /users
	
	//@PostMapping("/jpa/users/{Id}/posts")
//	public ResponseEntity<Object> createPostForUser(@PathVariable String Id,@Valid @RequestBody Post post){
//		
//		Optional<Users> user = userRepository.findById(Id);
//		if(user.isEmpty())
//			throw new UserNotFoundException("Id:"+Id);
//		post.setUser(user.get());
//		Post savedpost = postRepository.save(post);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(savedpost.getId())
//				.toUriString();
//		return ResponseEntity.created(location).build();
		
	//}
}
