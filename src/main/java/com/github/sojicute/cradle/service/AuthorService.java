package com.github.sojicute.cradle.service;

import com.github.sojicute.cradle.domain.Author;

import java.util.List;

public interface AuthorService {

    Author save(Author author);

    Author findById(long id);

    List<Author> findAll();

    Author findByName(String name);

}
