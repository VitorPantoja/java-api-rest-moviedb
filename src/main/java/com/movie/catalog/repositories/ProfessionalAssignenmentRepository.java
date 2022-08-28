package com.movie.catalog.repositories;

import com.movie.catalog.models.ProfessionalAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalAssignenmentRepository extends JpaRepository <ProfessionalAssignment, Long> {
}
