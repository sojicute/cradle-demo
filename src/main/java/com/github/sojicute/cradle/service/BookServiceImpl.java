package com.github.sojicute.cradle.service;

import com.github.sojicute.cradle.dao.BookDao;
import com.github.sojicute.cradle.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    final private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
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
