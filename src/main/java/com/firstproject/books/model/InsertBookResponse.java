package com.firstproject.books.model;

import com.firstproject.books.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class InsertBookResponse {
    Status status;
    List<String> errorMessages;

    public InsertBookResponse(){
        this.errorMessages =new ArrayList<String>();
    }

    public InsertBookResponse(Status status, List<String> errorMessages) {
        this.status = status;
        this.errorMessages = errorMessages;
    }

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

