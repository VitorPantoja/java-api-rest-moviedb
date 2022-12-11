package com.movie.catalog.repositories;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreLanguageRepository extends JpaRepository <GenreLanguage, Long> {
    List<GenreLanguage> findByGenre_Id(Long genreId);
}
