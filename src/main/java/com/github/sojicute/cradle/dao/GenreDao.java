package com.github.sojicute.cradle.dao;

import com.github.sojicute.cradle.domain.Genre;

import java.util.Optional;

public interface GenreDao {
    Genre save(Genre genre);

    Optional<Genre> findById(long id);

    Genre findByName(String name);
}
