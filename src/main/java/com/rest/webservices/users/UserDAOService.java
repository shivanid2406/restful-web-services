package com.rest.webservices.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDAOService {

	// create static list to talk to the UserDAOService
	private static List<Users> users = new ArrayList<>();
	static {

		users.add(new Users("1", "Adam", LocalDate.now().minusYears(30)));
		users.add(new Users("2", "Jim", LocalDate.now().minusYears(25)));
		users.add(new Users("3", "Joey", LocalDate.now().minusYears(35)));
	}

	public List<Users> findAll() {
		return users;
	}

	public Users save(Users user) {
		user.setId("4");
		users.add(user);
		return user;
	}
	
	public Users findOne(String Id) {
		
		/*
		 * java.util.function.Predicate<? super Users> predicate =
		 * user->user.getId().equals(Id); return
		 * users.stream().filter(predicate).findFirst().get();
		 */
		
		Users user = users.stream().filter(t->Id.equals(t.getId())).findFirst().orElse(null);
		return user;
	}
	
	public void deletebyId(String Id) {
		java.util.function.Predicate<? super Users> predicate = user->user.getId().equals(Id);
		users.removeIf(predicate);
		
		/*
		 * Users user =
		 * users.stream().filter(t->Id.equals(t.getId())).findFirst().orElse(null);
		 * return user;
		 */
	}
}
