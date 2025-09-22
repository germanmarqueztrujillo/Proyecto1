package com.example.library.book.service;

import org.springframework.stereotype.Service;

import com.example.library.book.model.Book;
import com.example.library.book.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }
}
