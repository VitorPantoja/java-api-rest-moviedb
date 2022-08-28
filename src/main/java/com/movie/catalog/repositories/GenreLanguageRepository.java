package com.movie.catalog.repositories;

import com.movie.catalog.models.GenreLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreLanguageRepository extends JpaRepository <GenreLanguage, Long> {
}
