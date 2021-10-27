package com.github.sojicute.cradle.dao;

import com.github.sojicute.cradle.domain.Author;
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

@DisplayName("Dao Author должен")
@DataJpaTest
@Import(AuthorDaoImpl.class)
public class AuthorDaoImplTest {

    private static final int AUTHORS_COUNT = 4;

    private static final String NEW_AUTHOR_NAME = "Фридрих Ницще";
    private static final long FIRST_AUTHOR_ID = 1;
    private static final String FIRST_AUTHOR_NAME = "Leo Tolstoy";


    @Autowired
    private AuthorDaoImpl authorDaoImpl;

    @Autowired
    private TestEntityManager em;

    @DisplayName("сохранить автора и загрузить")
    @Test
    void shouldSaveAuthor() {
        Author author = new Author(NEW_AUTHOR_NAME);

        Author newAuthor = authorDaoImpl.save(author);

        assertThat(newAuthor.getId()).isGreaterThan(0);

        val actualAuthor = em.find(Author.class, newAuthor.getId());
        assertThat(actualAuthor).isNotNull().matches(g -> !g.getName().equals(""));
    }

    @DisplayName("возвращать автора по id")
    @Test
    void shouldFindAuthorById() {
        Optional<Author> book = authorDaoImpl.findById(FIRST_AUTHOR_ID);
        assertThat(book).isNotEmpty().get().hasFieldOrPropertyWithValue("name", FIRST_AUTHOR_NAME);
    }


    @DisplayName("возвращать список всех авторов")
    @Test
    void shouldFindAllAuthors() {
        List<Author> authors = authorDaoImpl.findAll();
        assertThat(authors).hasSize(AUTHORS_COUNT);
    }

    @DisplayName("возвращать автор по name")
    @Test
    void shouldFindAuthorByName() {
        Author author = authorDaoImpl.findByName(FIRST_AUTHOR_NAME);
        val actualAuthor = em.find(Author.class, author.getId());
        assertThat(author).isNotNull();
        assertThat(author.getName()).isEqualTo(actualAuthor.getName());
    }
}
