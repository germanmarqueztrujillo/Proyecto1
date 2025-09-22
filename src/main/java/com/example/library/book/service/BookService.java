package com.example.library.book.service;

import org.springframework.stereotype.Service;

import com.example.library.book.dto.BookDTO;
import com.example.library.book.exception.BookNotFoundException;
import com.example.library.book.mapper.BookMapper;
import com.example.library.book.model.Book;
import com.example.library.book.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public void saveBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        bookRepository.save(book);
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDTO(book);
    }

    public void updateBookById(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException(id));

        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());

        bookRepository.save(book);
    }
}
