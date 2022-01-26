package com.firstproject.books.repository;

import com.firstproject.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Long> {
}
