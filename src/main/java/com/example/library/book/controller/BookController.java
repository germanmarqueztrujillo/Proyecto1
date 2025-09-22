package com.example.library.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.book.dto.BookDTO;
import com.example.library.book.service.BookService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void createBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBook(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO readBook(@PathVariable Long id) {
        return bookService.getBookById(id);
    }
}