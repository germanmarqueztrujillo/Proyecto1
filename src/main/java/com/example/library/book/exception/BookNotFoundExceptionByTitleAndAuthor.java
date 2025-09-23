package com.example.library.book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundExceptionByTitleAndAuthor extends RuntimeException {
    public BookNotFoundExceptionByTitleAndAuthor(String title, String author) {
        super("Books with title " + title + " and author " + author + " not found");
    }
}
