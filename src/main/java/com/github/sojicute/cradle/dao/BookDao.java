package com.github.sojicute.cradle.dao;

import com.github.sojicute.cradle.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    Book save (Book book);
    Optional<Book> findById(long id);

    List<Book> findAll();
    List<Book> findByTitle(String title);

    void updateTitleById(long id, String title);
    void deleteById(long id);

    List<Book> findAllBooksByGenreId(long id);
    List<Book> findAllBooksByAuthorId(long id);
}
