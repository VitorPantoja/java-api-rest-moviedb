package com.movie.catalog.controllers;

import com.movie.catalog.service.MovieService;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;
import com.movie.catalog.service.validations.ValidLanguage;
import com.movie.catalog.service.validations.ValidMovie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CreateUpdateMovieDTO dto){
        return ResponseEntity.ok(movieService.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") @Min(0) Integer offset,
                                    @RequestParam(defaultValue = "25") @Min(1) Integer limit,
                                    @RequestParam(defaultValue = "ASC") String sort) {
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(Sort.Direction.fromString(sort), "name", "name"));
        return ResponseEntity.ok(movieService.findAll(pageRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable @ValidMovie Long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

    @GetMapping("/findByGenre/{id}")
    public ResponseEntity<?> findByGenre(@PathVariable @ValidMovie Long id,
                                         @RequestParam(defaultValue = "0") @Min(0) Integer offset,
                                         @RequestParam(defaultValue = "25") @Min(1) Integer limit,
                                         @RequestParam(defaultValue = "ASC") String sort) {
        PageRequest pageRequest = PageRequest.of(offset, limit, Sort.by(Sort.Direction.fromString(sort), "name", "name"));
        return ResponseEntity.ok(movieService.findByGenre(id, pageRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @ValidMovie Long id){
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CreateUpdateMovieDTO dto){
        return ResponseEntity.ok(movieService.update(dto));
    }
}
