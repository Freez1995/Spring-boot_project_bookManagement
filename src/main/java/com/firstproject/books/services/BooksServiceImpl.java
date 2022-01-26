package com.firstproject.books.services;

import com.firstproject.books.model.Book;
import com.firstproject.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BooksServiceImpl implements BooksServiceInterface{

    @Autowired
    private BooksRepository booksRepo;

    // return book list sorted by name
    @Override
    public List<Book> findAllBooks() {
        List<Book> bookList= booksRepo.findAll();
        List<Book> sortedBookList = sortBooksByName(bookList);
        return sortedBookList;
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return booksRepo.findById(id);
    }

    @Override
    public Book createBookData(Book books) {
        return booksRepo.save(books);
    }

    @Override
    public void deleteBook(Long id) {
        booksRepo.deleteById(id);
    }

    private List<Book> sortBooksByName(List<Book> sortedBookList){
        return sortedBookList;
    }

 }
