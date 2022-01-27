package com.firstproject.books.model;

import com.firstproject.books.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class UpdateBookResponse {

//    private long id;
//    private String bookName;
//    private String authorName;
    private Status status;
    private List<String> errorMessages;

    public UpdateBookResponse(){
        this.errorMessages =new ArrayList<String>();
    }

    public UpdateBookResponse(long id, String bookName, String authorName, Status status, List<String> errorMessages) {
//        this.id = id;
//        this.bookName = bookName;
//        this.authorName = authorName;
        this.status = status;
        this.errorMessages = errorMessages;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
//
//    public String getAuthorName() {
//        return authorName;
//    }
//
//    public void setAuthorName(String authorName) {
//        this.authorName = authorName;
//    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
