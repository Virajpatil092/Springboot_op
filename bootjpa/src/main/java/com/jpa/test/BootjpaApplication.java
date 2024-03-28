package com.jpa.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.user;

@SpringBootApplication
public class BootjpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaApplication.class, args);
		
		UserRepo userrepo = context.getBean(UserRepo.class);
		
		// saving single user
//		user u = new user(2,"datta","nashik","BF");
//		userrepo.save(u);
		
		// saving multiple user
		
//		List<user> users = new ArrayList<>();
//		users.add(u);
//		userrepo.saveAll(users);
		
		// update user with given id
		
//		try {			
//			Optional<user> optional = userrepo.findById(1);
//			user u1 = optional.get();
//			System.out.println(u1);
//			u1.setName("Viraj");
//			userrepo.save(u1);
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		// fetching data
		
//		Iterable<user> users = userrepo.findAll();
//		
//		users.forEach(user->{
//			System.out.println(user);
//		});
		
		//Deleting user
		
//		userrepo.deleteById(1);
		
		// custom methods provided by spring boot
		
		List<user> users = userrepo.findByName("datta");
		
//		users.forEach(user->{
//			System.out.println(user);
//		});
		
		// custom methods with my own queries
		
//		users = userrepo.getAllUser();
//		
//		users.forEach(user->{
//			System.out.println(user);
//		});
		
		users = userrepo.getuserByName("datta");
		
		users.forEach(user->{
			System.out.println(user);
		});
	}
}
