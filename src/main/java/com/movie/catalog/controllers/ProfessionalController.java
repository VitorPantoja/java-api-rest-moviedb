package com.movie.catalog.controllers;

import com.movie.catalog.service.ProfessionalService;
import com.movie.catalog.service.dtos.CreateUpdateGenreLanguageDTO;
import com.movie.catalog.service.dtos.ProfessionalDTO;
import com.movie.catalog.service.validations.ValidProfessional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/professionals")
@RequiredArgsConstructor
@Slf4j
public class ProfessionalController {

    private final ProfessionalService professionalService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid ProfessionalDTO professional){
        return ResponseEntity.ok(professionalService.save(professional.getName()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @ValidProfessional Long id) {
        return ResponseEntity.ok(professionalService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(professionalService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @ValidProfessional Long id) {
        professionalService.delete(id);
        return ResponseEntity.ok().build();
    }
}
