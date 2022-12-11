package com.movie.catalog.service.impls;

import com.movie.catalog.models.Movie;
import com.movie.catalog.repositories.MovieRepository;
import com.movie.catalog.service.GenreLanguageService;
import com.movie.catalog.service.MovieService;
import com.movie.catalog.service.dtos.CreateUpdateGenreLanguageDTO;
import com.movie.catalog.service.dtos.CreateUpdateMovieDTO;
import com.movie.catalog.service.dtos.CreateUpdateProfessionalAssignmentDTO;
import com.movie.catalog.service.dtos.MovieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie update(CreateUpdateMovieDTO movieDTO) {
        var movieToUpdate = movieRepository.findById(movieDTO.getId()).orElse(null);
        if (nonNull(movieToUpdate)) {
            movieToUpdate.setImage(nonNull(movieDTO.getImage()) ? movieDTO.getImage() : movieToUpdate.getImage());
            movieToUpdate.setName(nonNull(movieDTO.getName()) ? movieDTO.getName() : movieToUpdate.getName());
            movieToUpdate.setSynopsis(nonNull(movieDTO.getSynopsis()) ? movieDTO.getSynopsis() : movieToUpdate.getSynopsis());
            if (nonNull(movieDTO.getGenreLanguagesDTOS())) {
                movieToUpdate.setLanguages(movieDTO.getGenreLanguagesDTOS().stream()
                        .map(CreateUpdateGenreLanguageDTO::toEntity)
                        .collect(Collectors.toSet()));
            }
            if (nonNull(movieDTO.getProfessionalAssignmentDTOS())) {
                movieToUpdate.setMovieSet(movieDTO.getProfessionalAssignmentDTOS().stream()
                        .map(CreateUpdateProfessionalAssignmentDTO::toEntity)
                        .collect(Collectors.toSet()));
            }
        }
        return movieToUpdate;
    }
}
