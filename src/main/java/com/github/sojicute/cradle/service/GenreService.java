package com.github.sojicute.cradle.service;

import com.github.sojicute.cradle.domain.Genre;

import java.util.List;

public interface GenreService {
    Genre save(Genre genre);

    Genre findById(long id);

    List<Genre> findAll();

    Genre findByName(String name);
}
