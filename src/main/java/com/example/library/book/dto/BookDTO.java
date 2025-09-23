package com.example.library.book.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
  @NotBlank private String title;

  @NotBlank private String author;

  @NotBlank private String isbn;
}
