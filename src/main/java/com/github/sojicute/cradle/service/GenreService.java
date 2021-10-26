package com.github.sojicute.cradle.service;

import com.github.sojicute.cradle.domain.Genre;

public interface GenreService {
    Genre save(Genre genre);

    Genre findById(long id);

    Genre findByName(String name);
}
