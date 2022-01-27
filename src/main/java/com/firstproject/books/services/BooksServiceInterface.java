package com.firstproject.books.services;
import com.firstproject.books.model.Book;
import com.firstproject.books.model.InsertBookResponse;
import com.firstproject.books.model.UpdateBookResponse;

import java.util.List;

public interface BooksServiceInterface {

    // get all books
    public List<Book> findAllBooks();

    // get book by ID
    public Book findBookById(Long id);

    // add book to DB
    public InsertBookResponse insertBookData(Book book);

    // update book
    public UpdateBookResponse updateBookData(Book book);

    // delete book from DB
    public void deleteBook(Long id);
}


