package com.firstproject.books.controller;

import com.firstproject.books.model.Book;
import com.firstproject.books.services.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BooksController {

    @Autowired
    private BooksServiceImpl booksService;

    // get all books
    @GetMapping("/books")
    @ResponseBody
    public List<Book> getAllBooks(){
        return booksService.findAllBooks();
    }

    // get book by id
    @GetMapping("/books/{id}")
    @ResponseBody
    public Optional<Book> getBookById(@PathVariable Long id){
        return booksService.findBookById(id);
    }

    // add book to db
    @PostMapping("/books")
    public Book createBookData(@RequestBody Book books){
        return booksService.createBookData(books);
    }

    // update book information
    @PutMapping("/books/{id}")
    @ResponseBody
    public Book updateBookInfo(@PathVariable Long id, @RequestBody Book updatedBook) {

//        String bookName = updatedBook.getBookName();
        String bookAuthor = updatedBook.getAuthorName();

        Optional<Book> book = booksService.findBookById(id);

        Book finalBook = null;
        if (book.isPresent()) {
            finalBook = book.get();
            finalBook.setBookName(updatedBook.getBookName());
            finalBook.setAuthorName(bookAuthor);
            finalBook = booksService.createBookData(finalBook);
        }
        return finalBook;
    }

    // delete book from db
    @DeleteMapping("/books/{id}")
    @ResponseBody
    public String deleteBook(@PathVariable Long id){

        booksService.deleteBook(id);
        return "Book has been deleted";
    }

}
