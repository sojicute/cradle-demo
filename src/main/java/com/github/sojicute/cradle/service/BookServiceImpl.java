package com.github.sojicute.cradle.service;

import com.github.sojicute.cradle.dao.BookDao;
import com.github.sojicute.cradle.domain.Author;
import com.github.sojicute.cradle.domain.Book;
import com.github.sojicute.cradle.domain.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    final private BookDao bookDao;
    final private AuthorService authorService;
    final private GenreService genreService;

    @Autowired
    public BookServiceImpl(BookDao bookDao, AuthorService authorService, GenreService genreService) {
        this.bookDao = bookDao;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @Override
    public void addBook(Book book) {
        Author author = authorService.findByName(book.getAuthor().getName());
        if (author == null) author = new Author(book.getAuthor().getName());
        Genre genre = genreService.findByName(book.getGenre().getName());
        if (genre == null) genre = new Genre(book.getGenre().getName());
        book.setAuthor(author);
        book.setGenre(genre);
        bookDao.save(book);
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book findById(long id) {
        return bookDao.findById(id).get();
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.findByTitle(title);
    }

    @Override
    public void updateTitleById(long id, String title) {
        bookDao.updateTitleById(id, title);
    }

    @Override
    public void deleteById(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> findAllBooksByGenreId(long id) {
        return findAllBooksByGenreId(id);
    }

    @Override
    public List<Book> findAllBooksByAuthorId(long id) {
        return findAllBooksByAuthorId(id);
    }

}
