package com.movie.catalog.controllers;

import com.movie.catalog.service.MovieService;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CreateUpdateMovieDTO dto){
        System.out.println("ok");
        return ResponseEntity.ok(movieService.save(dto));
    }

}
