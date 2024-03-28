package com.springboot.web.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.springboot.web.dao.bookRepo;
import com.springboot.web.entities.Books;

@Component
public class bookService {
	
	@Autowired
	private bookRepo bookrepo;

	public List<Books> getallBooks(){
		return (List<Books>) this.bookrepo.findAll();
	}

	public Books getbookbyid(int id) {

		Books book = null;

		try {
			book = this.bookrepo.findById(id);			
		}
		catch(Exception e) {
			System.out.println("Not found");
		}

		return book;

	}
	
	public void addbook(Books book) {
		this.bookrepo.save(book);
	}
	
	public void deletebook(int id) {
		this.bookrepo.deleteById(id);
	}
	
	public void update(int id, Books book) {
		this.bookrepo.deleteById(id);
		this.bookrepo.save(book);
	}
}