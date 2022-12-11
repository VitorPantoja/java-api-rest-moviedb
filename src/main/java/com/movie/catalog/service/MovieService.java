package com.movie.catalog.service;

import com.movie.catalog.models.Movie;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;
import com.movie.catalog.service.dtos.MovieDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface MovieService {

    Movie save(CreateUpdateMovieDTO movie);

    Page<MovieDTO> findAll(PageRequest pageRequest);

    MovieDTO findById(Long id);

    Page<MovieDTO> findByGenre(Long genreId, PageRequest pageRequest);

    void delete(Long id);

    Movie update(CreateUpdateMovieDTO movieDTO);

}
