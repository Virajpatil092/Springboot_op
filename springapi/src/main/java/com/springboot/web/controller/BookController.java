package com.springboot.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.entities.Books;
import com.springboot.web.services.bookService;

@RestController
public class BookController {
	
	@Autowired
	private bookService bookservice;
	
	@GetMapping("/books")
	public ResponseEntity<List<Books>> getBooks() {
		List<Books> list = this.bookservice.getallBooks();

		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getbook(@PathVariable("id") int id) {
		Books book = this.bookservice.getbookbyid(id);
		
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Books> addbook(@RequestBody Books book) {
		try {
			this.bookservice.addbook(book);
			
			return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {

		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("/books/{id}")
	public Books deletebook(@PathVariable("id") int id) {
		Books b = this.bookservice.getbookbyid(id);
		this.bookservice.deletebook(id);
		return b;
	}
	
	@PutMapping("/books/{id}")
	public Books updatebook(@PathVariable("id") int id,@RequestBody Books book) {
		
		this.bookservice.update(id,book);
		
		return book;
	}
}