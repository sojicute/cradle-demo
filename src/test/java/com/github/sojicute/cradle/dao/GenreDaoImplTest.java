package com.github.sojicute.cradle.dao;

import com.github.sojicute.cradle.domain.Author;
import com.github.sojicute.cradle.domain.Book;
import com.github.sojicute.cradle.domain.Genre;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao Genre должен")
@DataJpaTest
@Import(GenreDaoImpl.class)
public class GenreDaoImplTest {

    private static final int GENRES_COUNT = 4;

    private static final String NEW_GENRE_NAME = "Философия";

    private static final long FIRST_GENRE_ID = 1;
    private static final String FIRST_GENRE_NAME = "Novel";

    @Autowired
    private GenreDaoImpl genreDaoImpl;

    @Autowired
    private TestEntityManager em;


    @DisplayName("сохранить жанр а потом загрузить")
    @Test
    void shouldSaveGenre() {
        Genre genre = new Genre(NEW_GENRE_NAME);

        Genre newGenre = genreDaoImpl.save(genre);

        assertThat(newGenre.getId()).isGreaterThan(0);

        val actualGenre = em.find(Genre.class, newGenre.getId());
        assertThat(actualGenre).isNotNull().matches(g -> !g.getName().equals(""));
    }

    @DisplayName("возвращать жанр по id")
    @Test
    void shouldFindGenreById() {
        Optional<Genre> book = genreDaoImpl.findById(FIRST_GENRE_ID);
        assertThat(book).isNotEmpty().get()
                .hasFieldOrPropertyWithValue("name", FIRST_GENRE_NAME);
    }

    @DisplayName("возвращать список всех жанров")
    @Test
    void shouldFindAllGenres() {
        List<Genre> genres = genreDaoImpl.findAll();
        assertThat(genres).hasSize(GENRES_COUNT);
    }


    @DisplayName("возвращать жанр по name")
    @Test
    void shouldFindGenreByName() {
        Genre genre = genreDaoImpl.findByName(FIRST_GENRE_NAME);
        val actualGenre = em.find(Genre.class, genre.getId());
        assertThat(genre).isNotNull();
        assertThat(genre.getName()).isEqualTo(actualGenre.getName());
    }
}
