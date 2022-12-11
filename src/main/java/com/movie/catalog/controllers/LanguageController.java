package com.movie.catalog.controllers;

import com.movie.catalog.service.LanguageService;
import com.movie.catalog.service.dtos.LanguageDTO;
import com.movie.catalog.service.validations.ValidLanguage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping(value = "/api/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService languageService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid LanguageDTO dto){
        return ResponseEntity.ok(languageService.save(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(languageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @ValidLanguage Long id) {
        return ResponseEntity.ok(languageService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @ValidLanguage Long id) {
        languageService.delete(id);
        return ResponseEntity.ok().build();
    }
}
