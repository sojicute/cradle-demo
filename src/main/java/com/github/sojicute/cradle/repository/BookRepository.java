package com.github.sojicute.cradle.repository;

import com.github.sojicute.cradle.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
