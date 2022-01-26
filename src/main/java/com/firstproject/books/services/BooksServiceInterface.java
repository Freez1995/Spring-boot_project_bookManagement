package com.firstproject.books.services;
import com.firstproject.books.model.Book;

import java.util.List;
import java.util.Optional;

public interface BooksServiceInterface {

    // get all books
    public List<Book> findAllBooks();

    // get book by ID
    public Optional<Book> findBookById(Long id);

    // add book to DB
    public Book createBookData(Book books);

    // delete book from DB
    public void deleteBook(Long id);
}


