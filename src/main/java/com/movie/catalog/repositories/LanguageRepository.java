package com.movie.catalog.repositories;

import com.movie.catalog.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository <Language, Long> {
    Optional<Language> findByName(String name);
}
