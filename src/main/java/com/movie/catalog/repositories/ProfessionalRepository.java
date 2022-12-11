package com.movie.catalog.repositories;

import com.movie.catalog.models.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository <Professional, Long> {
    Optional<Professional> findByName(String name);
}
