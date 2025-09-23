package com.example.library.book.repository;

import com.example.library.book.model.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @Modifying
  @Transactional
  @Query("UPDATE Book b SET b.title = :title WHERE b.id = :id")
  void updateTitleById(@Param("id") Long id, @Param("title") String title);

  Optional<Book> findByTitleAndAuthor(String title, String author);
}
