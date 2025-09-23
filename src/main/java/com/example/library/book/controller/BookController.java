package com.example.library.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.book.dto.BookDTO;
import com.example.library.book.service.BookService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void createBook(@Valid @RequestBody BookDTO bookDTO) {
        bookService.saveBook(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO readBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public void updateBookById(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        bookService.updateBookById(id, bookDTO);
    }

    @PatchMapping("/{id}")
    public void updateBookTitleById(@PathVariable Long id, @Valid @RequestBody BookDTO bookDTO) {
        bookService.updateBookTitleById(id, bookDTO);
    }
}