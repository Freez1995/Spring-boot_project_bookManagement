package com.firstproject.books.controller;

import com.firstproject.books.model.Book;
import com.firstproject.books.model.DeleteBookResponse;
import com.firstproject.books.model.InsertBookResponse;
import com.firstproject.books.model.UpdateBookResponse;
import com.firstproject.books.services.BooksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Book getBookById(@PathVariable Long id){
        return booksService.findBookById(id);
    }

    // insert book to db
    @PostMapping("/books")
    public InsertBookResponse createBookData(@RequestBody Book book){
        return booksService.insertBookData(book);
    }

    // update book information
    @PutMapping("/book/update")
    @ResponseBody
    public UpdateBookResponse updateBookInfo(@RequestBody Book bookForUpdate) {
        return booksService.updateBookData(bookForUpdate);
    }

    // delete book from db
    @DeleteMapping("/books/{id}")
    @ResponseBody
    public DeleteBookResponse deleteBook(@PathVariable Long id){
        booksService.deleteBook(id);
        return new DeleteBookResponse("Book has been deleted");
    }

}
