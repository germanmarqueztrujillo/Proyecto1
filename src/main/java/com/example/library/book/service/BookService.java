package com.example.library.book.service;

import org.springframework.stereotype.Service;

import com.example.library.book.dto.BookDTO;
import com.example.library.book.exception.BookNotFoundExceptionById;
import com.example.library.book.exception.BookNotFoundExceptionByTitleAndAuthor;
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
        .orElseThrow(() -> new BookNotFoundExceptionById(id));
        return bookMapper.toDTO(book);
    }

    public BookDTO getBookByTitleAndAuthor(String title, String author) {
        Book book = bookRepository.findByTitleAndAuthor(title, author)
        .orElseThrow(() -> new BookNotFoundExceptionByTitleAndAuthor(title, author));
        return bookMapper.toDTO(book);
    }

    public void updateBookById(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundExceptionById(id));

        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());

        bookRepository.save(book);
    }

    public void updateBookTitleById(Long id, BookDTO bookDTO) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundExceptionById(id);
        }
        bookRepository.updateTitleById(id, bookDTO.getTitle());
    }

    public void deleteBookById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundExceptionById(id);
        }
        bookRepository.deleteById(id);
    }
}
