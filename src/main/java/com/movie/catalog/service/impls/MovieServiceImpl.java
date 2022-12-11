package com.movie.catalog.service.impls;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.models.Movie;
import com.movie.catalog.repositories.MovieRepository;
import com.movie.catalog.service.GenreLanguageService;
import com.movie.catalog.service.GenreService;
import com.movie.catalog.service.MovieService;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;
import com.movie.catalog.service.dtos.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final GenreLanguageService genreLanguageService;

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

    @Override
    public Page<MovieDTO> findByGenre(Long genreId, PageRequest pageRequest) {
        var movies = genreLanguageService.findByGenre_Id(genreId).stream()
                .map(genreLanguage -> MovieDTO.fromEntity(genreLanguage.getMovie())).collect(Collectors.toList());
        final int end = (int) Math.min((pageRequest.getOffset() + pageRequest.getPageSize()), movies.size());
        return new PageImpl<>(movies.subList((int) pageRequest.getOffset(), end), pageRequest, movies.size());
    }
}
