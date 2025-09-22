package com.example.library.book.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.library.book.dto.BookDTO;
import com.example.library.book.model.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id", ignore = true)
    Book toEntity(BookDTO dto);
    BookDTO toDTO(Book book);
}