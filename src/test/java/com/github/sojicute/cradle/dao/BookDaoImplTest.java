package com.github.sojicute.cradle.dao;

import com.github.sojicute.cradle.dao.BookDaoImpl;
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


@DisplayName("Dao Book должен")
@DataJpaTest
@Import(BookDaoImpl.class)
public class BookDaoImplTest {
    private static final int BOOKS_COUNT = 5;

    private static final String NEW_BOOK_TITLE = "Воля к власти";

    private static final long FIRST_BOOK_ID = 1;
    private static final String FIRST_BOOK_TITLE = "War and Peace";

    private static final long SECOND_BOOK_ID = 2;
    private static final String NEW_SECOND_BOOK_TITLE = "GATSBY";


    @Autowired
    private BookDaoImpl bookDaoImpl;

    @Autowired
    private TestEntityManager em;


    @DisplayName("сохранить книгу а потом загрузить")
    @Test
    void shouldSaveBook() {
        val author = new Author("Ницше");
        val genre = new Genre("Философия");

        Book book = new Book(NEW_BOOK_TITLE, author, genre);
        Book newBook = bookDaoImpl.save(book);

        assertThat(newBook.getId()).isGreaterThan(0);

        val actualBook = em.find(Book.class, newBook.getId());
        assertThat(actualBook).isNotNull().matches(b -> !b.getTitle().equals(""))
                .matches(b -> b.getAuthor() != null);


    }

    @DisplayName("возвращать список всех книг")
    @Test
    void shouldFindAllBooks() {
        List<Book> books = bookDaoImpl.findAll();
        assertThat(books).hasSize(BOOKS_COUNT);
    }

    @DisplayName("возвращать книгу по id")
    @Test
    void shouldFindBookId() {
        Optional<Book> book = bookDaoImpl.findById(FIRST_BOOK_ID);
        assertThat(book).isNotEmpty().get()
                .hasFieldOrPropertyWithValue("title", FIRST_BOOK_TITLE);
    }


    @DisplayName("возвращать список книг по заголовку title")
    @Test
    void shouldFindBooksByTitle() {
        val book = em.find(Book.class, FIRST_BOOK_ID);
        List<Book> books = bookDaoImpl.findByTitle(FIRST_BOOK_TITLE);
        assertThat(books).containsOnly(book);
    }


    @DisplayName("изменять значения заголовка по id")
    @Test
    void updateBooksTitleById() {
        bookDaoImpl.updateTitleById(SECOND_BOOK_ID, NEW_SECOND_BOOK_TITLE);

        val secondBook = em.find(Book.class, SECOND_BOOK_ID);
        assertThat(secondBook.getTitle()).isEqualTo(NEW_SECOND_BOOK_TITLE);
    }

    @DisplayName("возвращать список книг по жанру")
    @Test
    void shouldFindAllBooksByGenreId() {
        val book = em.find(Book.class, FIRST_BOOK_ID);
        List<Book> books = bookDaoImpl.findAllBooksByGenreId(book.getGenre().getId());
        assertThat(books).contains(book);
    }

    @DisplayName("возвращать список книг по автору")
    @Test
    void shouldFindAllBooksByAuthorId() {
        val book = em.find(Book.class, FIRST_BOOK_ID);
        List<Book> books = bookDaoImpl.findAllBooksByGenreId(book.getAuthor().getId());
        assertThat(books).contains(book);
    }


    @DisplayName("удалять книгу по id")
    @Test
    void deleteBookById() {
        em.clear();
        bookDaoImpl.deleteById(FIRST_BOOK_ID);
        val deletedBook = em.find(Book.class, FIRST_BOOK_ID);
        assertThat(deletedBook).isNull();
    }
}

