package com.rest.webservices.users;

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

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDAOService service;

	public UserResource(UserDAOService service) {
		super();
		this.service = service;
	};
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		
		return service.findAll();
	}
	
	/*
	 * @GetMapping("/users/{Id}") public EntityModel<Users>
	 * retrieveUser(@PathVariable String Id) {
	 * 
	 * Users user = service.findOne(Id); if (user==null) throw new
	 * UserNotFoundException("Id:" + Id); EntityModel<Users> entityModel =
	 * EntityModel.of(user); WebMvcLinkBuilder link =
	 * linkTo(methoOn(this.getClass()).RetrieveAllUsers());
	 * entityModel.add(link.withRel("all-users")); return entityModel; }
	 */
	
	@DeleteMapping("/users/{Id}")
	public void deleteUser(@PathVariable String Id) {
		service.deletebyId(Id);
	}
	
	/*
	 * @PostMapping("/users") public ResponseEntity<Users>
	 * createUser(@Valid @RequestBody Users user){
	 * 
	 * Users savedUser = service.save(user); URI location =
	 * ServletUriComponentsBuilder .fromCurrentRequest().path("/{Id}")
	 * .buildAndExpand(savedUser.getId()) .toUri(); return
	 * ResponseEntity.created(location).build(); }
	 */
}
