package com.movie.catalog.service;

import com.movie.catalog.models.MovieDetails;
import com.movie.catalog.service.dtos.CreateUpdateMovieDetailsDTO;

public interface MovieDetailsService {
    MovieDetails save(CreateUpdateMovieDetailsDTO dto);
}
