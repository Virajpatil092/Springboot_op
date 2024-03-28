package com.springboot.web.dao;

import org.springframework.data.repository.CrudRepository;
import com.springboot.web.entities.Books;

public interface bookRepo extends CrudRepository<Books, Integer>{
	public Books findById(int id);
}