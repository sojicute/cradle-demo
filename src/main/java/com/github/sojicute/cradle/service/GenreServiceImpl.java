package com.github.sojicute.cradle.service;

import com.github.sojicute.cradle.dao.GenreDao;
import com.github.sojicute.cradle.domain.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
    final private GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public Genre save(Genre genre) {
        return genreDao.save(genre);
    }

    @Override
    public Genre findById(long id) {
        return genreDao.findById(id).get();
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public Genre findByName(String name) {
        return genreDao.findByName(name);
    }
}
