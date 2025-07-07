package com.iuri.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iuri.library.entities.Book;
import com.iuri.library.entities.BookStatus;
import com.iuri.library.entitiesDTO.BookSearchResultDTO;
import com.iuri.library.repositories.BookRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Value("${google.books.api.url}")
	private String apiUrl;

	@Value("${google.books.api.key}")
	private String apiKey;

	@Autowired
	private BookRepository bookRepository;

	public BookSearchResultDTO searchBooks(String query) {
		RestTemplate restTemplate = new RestTemplate();

		String url = UriComponentsBuilder.fromHttpUrl(apiUrl).queryParam("q", query).queryParam("key", apiKey)
				.toUriString();

		String rawResponse = restTemplate.getForObject(url, String.class);

		ObjectMapper objectMapper = new ObjectMapper();

		try {
			BookSearchResultDTO result = objectMapper.readValue(rawResponse, BookSearchResultDTO.class);
			System.out.println("Conversão do JSON para DTO realizada com sucesso!");
			return result;
		} catch (JsonProcessingException e) {
			System.err.println("Erro ao converter o JSON da resposta: " + e.getMessage());
			return null;
		}
	}

	@Transactional
	public Book updateStatus(Long id, BookStatus newStatus) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Livro não encontrado com o ID: " + id));

		book.setStatus(newStatus);

		return bookRepository.save(book);
	}

	@Transactional
	public void delete(Long id) {
		if (!bookRepository.existsById(id)) {
			throw new EntityNotFoundException("Livro não encontrado com o ID: " + id);
		}
		bookRepository.deleteById(id);
	}
}
