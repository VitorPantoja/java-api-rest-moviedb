package com.movie.catalog.controllers;

import com.movie.catalog.service.GenreLanguageService;
import com.movie.catalog.service.dtos.CreateUpdateGenreLanguageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/genre-languages")
@RequiredArgsConstructor
@Slf4j
public class GenreLanguageController {

    private final GenreLanguageService genreLanguageService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreateUpdateGenreLanguageDTO dto){
        System.out.println("ok");
        return ResponseEntity.ok(genreLanguageService.save(dto));
    }

}
