package com.github.sojicute.cradle.repository;

import com.github.sojicute.cradle.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
