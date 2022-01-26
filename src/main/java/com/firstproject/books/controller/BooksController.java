package com.firstproject.books.controller;

import com.firstproject.books.model.Books;
import com.firstproject.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    private BooksRepository booksRepo;

    // get all books
    @GetMapping("/books")
    @ResponseBody
    public List<Books> getAllBooks(){
        return booksRepo.findAll();
    }

    // get book by id
    @GetMapping("/books/{id}")
    @ResponseBody
    public Optional<Books> getBookById(@PathVariable Long id){
        return booksRepo.findById(id);
    }

    // add book to db
    @PostMapping("/books")
    public Books createBookData(@RequestBody Books books){
        return booksRepo.save(books);
    }

    // update book information
    @PutMapping("/books/{id}")
    @ResponseBody
    public Books updateBookInfo(@PathVariable Long id, @RequestBody Books updatedBook){

        Books book = booksRepo.getById(id);
        String bookName = updatedBook.getBookName();
        String bookAuthor = updatedBook.getAuthorName();

        book.setBookName(bookName);
        book.setAuthorName(bookAuthor);
        return booksRepo.save(book);
    }

    // delete book from db
    @DeleteMapping("/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id){

        Books book = booksRepo.getById(id);
        booksRepo.delete(book);
        return "Book deleted from database";
    }

}
