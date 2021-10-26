package com.github.sojicute.cradle.service;

import com.github.sojicute.cradle.domain.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book findById(long id);

    List<Book> findAll();
    List<Book> findByName(String name);

    void updateNameById(long id, String name);
    void deleteById(long id);

    List<Book> findAllBooksByGenreId(long id);
    List<Book> findAllBooksByAuthorId(long id);
}
