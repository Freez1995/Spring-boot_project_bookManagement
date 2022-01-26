package com.firstproject.books.controller;

import com.firstproject.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @Autowired
    private BooksRepository booksRepo;



}
