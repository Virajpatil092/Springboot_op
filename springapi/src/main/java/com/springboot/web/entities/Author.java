package com.springboot.web.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String language;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
	private Books book;
	
	public Author(int id, String name, String language, Books book) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.book = book;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", language=" + language + ", book=" + book + "]";
	}
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
