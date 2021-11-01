package com.github.sojicute.cradle.repository;

import com.github.sojicute.cradle.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
