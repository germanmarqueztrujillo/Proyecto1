package com.example.library.book.mapper;

import com.example.library.book.dto.BookDTO;
import com.example.library.book.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
  @Mapping(target = "id", ignore = true)
  Book toEntity(BookDTO dto);

  BookDTO toDTO(Book book);
}
