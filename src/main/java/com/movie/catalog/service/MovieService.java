package com.movie.catalog.service;

import com.movie.catalog.models.Movie;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;

public interface MovieService {

    Movie save(CreateUpdateMovieDTO movie);

}
