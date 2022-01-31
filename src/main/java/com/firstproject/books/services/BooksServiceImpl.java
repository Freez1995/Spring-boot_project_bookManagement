package com.firstproject.books.services;

import com.firstproject.books.enums.Status;
import com.firstproject.books.model.Book;
import com.firstproject.books.model.InsertBookResponse;
import com.firstproject.books.model.UpdateBookResponse;
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
        if (!bookList.isEmpty()){
            sortBooksByName(bookList);
        }
        return bookList;
    }

    @Override
    public Book findBookById(Long id) {
        Optional<Book> bookFromRepo = booksRepo.findById(id);
        if (bookFromRepo.isPresent()){
            return bookFromRepo.get();
        }
        return new Book();
    }

    @Override
    public InsertBookResponse insertBookData(Book book) {
        InsertBookResponse bookResponse = validateBookData(book);
        if (bookResponse.getStatus() == Status.OK){
            Book savedBook = booksRepo.save(book);
        }
        return bookResponse;
    }

    private InsertBookResponse validateBookData(Book book) {
        InsertBookResponse bookResponse = new InsertBookResponse();
        if (book.getBookName() == null || book.getBookName() == ""){
            bookResponse.setStatus(Status.ERROR);
            bookResponse.getErrorMessages().add("Invalid book name");
        }
        if(book.getAuthorName() == null || book.getAuthorName() == ""){
            bookResponse.setStatus(Status.ERROR);
            bookResponse.getErrorMessages().add("Invalid author name");
        }
        if (bookResponse.getErrorMessages().isEmpty()){
            bookResponse.setStatus(Status.OK);
        }
        return bookResponse;
    }

    @Override
    public UpdateBookResponse updateBookData(Book book) {
        UpdateBookResponse bookResponse = validateBookDataForUpdate(book);
        if (bookResponse.getStatus() == Status.OK){
            Book updatedBook = booksRepo.save(book);
        }
        return bookResponse;
    }

    private UpdateBookResponse validateBookDataForUpdate(Book book) {
        UpdateBookResponse bookResponse = new UpdateBookResponse();
        Optional<Book> checkIfBookExist = booksRepo.findById(book.getId());
        if (checkIfBookExist.isEmpty()){
            bookResponse.setStatus(Status.ERROR);
            bookResponse.getErrorMessages().add("Book with the entered ID does not exist");
        }
        if (book.getBookName() == null || book.getBookName() == ""){
            bookResponse.setStatus(Status.ERROR);
            bookResponse.getErrorMessages().add("Book name is empty");
        }
        if(book.getAuthorName() == null || book.getAuthorName() == ""){
            bookResponse.setStatus(Status.ERROR);
            bookResponse.getErrorMessages().add("Book author is empty");
        }
        if (bookResponse.getErrorMessages().isEmpty()){
            bookResponse.setStatus(Status.OK);
        }
        return bookResponse;
    }

    @Override
    public void deleteBook(Long id) {
        booksRepo.deleteById(id);
    }

    private void sortBooksByName(List<Book> bookList){
        bookList.sort(new Comparator<Book>() {
            public int compare(Book o1, Book o2) {
                return o1.getBookName().compareToIgnoreCase(o2.getBookName());
            }
        });
    }

 }
