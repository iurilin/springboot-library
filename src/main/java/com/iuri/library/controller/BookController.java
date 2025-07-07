package com.iuri.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iuri.library.entities.Book;
import com.iuri.library.entitiesDTO.AddBookDTO;
import com.iuri.library.entitiesDTO.BookSearchResultDTO;
import com.iuri.library.repositories.BookRepository;
import com.iuri.library.service.BookService;


@RestController
@RequestMapping("api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("search")
	public ResponseEntity<BookSearchResultDTO> searchBooks(@RequestParam("query") String query) {
		BookSearchResultDTO result = bookService.searchBooks(query);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Book> addBookToLibrary(@RequestBody AddBookDTO bookDTO) {
	    Book newBook = new Book();
	    newBook.setTitle(bookDTO.getTitle());
	    
	    if (bookDTO.getAuthors() != null) {
	        newBook.setAuthors(String.join(", ", bookDTO.getAuthors()));
	    }
	    
	    newBook.setDescription(bookDTO.getDescription());
	    newBook.setThumbnailUrl(bookDTO.getThumbnailUrl());
	    newBook.setStatus(bookDTO.getStatus());

	    Book savedBook = bookRepository.save(newBook);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}

}
