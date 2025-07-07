package com.iuri.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iuri.library.entitiesDTO.BookSearchResultDTO;
import com.iuri.library.service.BookService;

@RestController
@RequestMapping("api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("search")
	public ResponseEntity<BookSearchResultDTO> searchBooks(@RequestParam("query") String query) {
		BookSearchResultDTO result = bookService.searchBooks(query);
		return ResponseEntity.ok(result);
	}

}
