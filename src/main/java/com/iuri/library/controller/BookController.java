package com.iuri.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iuri.library.entities.Book;
import com.iuri.library.entitiesDTO.AddBookDTO;
import com.iuri.library.entitiesDTO.BookSearchResultDTO;
import com.iuri.library.entitiesDTO.UpdateBookStatusDTO;
import com.iuri.library.repositories.BookRepository;
import com.iuri.library.service.BookService;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "http://localhost:3000")
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

	@Transactional
	public Book addBookToLibrary(AddBookDTO bookRequest) {
	    
	    Book newBook = new Book();
	    newBook.setTitle(bookRequest.getTitle());
	    
	    if (bookRequest.getAuthors() != null && !bookRequest.getAuthors().isEmpty()) {
	        newBook.setAuthors(String.join(", ", bookRequest.getAuthors()));
	    } else {
	        newBook.setAuthors("Autor desconhecido");
	    }

	    newBook.setDescription(bookRequest.getDescription());
	    newBook.setThumbnailUrl(bookRequest.getThumbnailUrl());
	    
	    newBook.setStatus(bookRequest.getStatus());

	    return bookRepository.save(newBook);
	}

	@PatchMapping("/{id}/status")
	public ResponseEntity<Book> updateBookStatus(@PathVariable Long id, @RequestBody UpdateBookStatusDTO dto) {
		Book updatedBook = bookService.updateStatus(id, dto.getStatus());
		return ResponseEntity.ok(updatedBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		bookService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
