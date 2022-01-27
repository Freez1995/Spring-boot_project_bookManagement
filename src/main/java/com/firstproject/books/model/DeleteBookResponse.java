package com.firstproject.books.model;

public class DeleteBookResponse {
    String message;

    public  DeleteBookResponse(){}

    public DeleteBookResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
