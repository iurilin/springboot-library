package com.iuri.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iuri.library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
