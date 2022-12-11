package com.movie.catalog.service;

import com.movie.catalog.models.Genre;

import java.util.List;

public interface GenreService {
    Genre save(String genreName);

    List<Genre> findAll();

    Genre findById(Long id);

    void delete(Long id);
}
