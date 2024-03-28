package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.user;

public interface UserRepo extends CrudRepository<user, Integer> {
	public List<user> findByName(String name);
	
	@Query("select u from user u")
	public List<user> getAllUser();
	
	
	//Don't give space between ':' and 'n'
	@Query("select u from user u where u.name = :n")
	public List<user> getuserByName(@Param("n") String name);
}