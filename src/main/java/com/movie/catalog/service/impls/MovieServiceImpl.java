package com.movie.catalog.service.impls;

import com.movie.catalog.models.Movie;
import com.movie.catalog.repositories.MovieRepository;
import com.movie.catalog.service.MovieService;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;
import com.movie.catalog.service.dtos.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Movie save(CreateUpdateMovieDTO movie) {
        return movieRepository.saveAndFlush(movie.toEntity());
    }

    @Override
    public Page<MovieDTO> findAll(PageRequest pageRequest) {
        return movieRepository.findAll(pageRequest).map(MovieDTO::fromEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        return MovieDTO.fromEntity(Objects.requireNonNull(movieRepository.findById(id).orElse(null)));
    }
}
