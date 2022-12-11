package com.movie.catalog.controllers;

import com.movie.catalog.service.GenreService;
import com.movie.catalog.service.dtos.GenreDTO;
import com.movie.catalog.service.validations.ValidGenre;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/api/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid GenreDTO genreName){
        return ResponseEntity.ok(genreService.save(genreName.getName()));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(genreService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @ValidGenre Long id) {
        return ResponseEntity.ok(genreService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @ValidGenre Long id) {
        genreService.delete(id);
        return ResponseEntity.ok().build();
    }
}
