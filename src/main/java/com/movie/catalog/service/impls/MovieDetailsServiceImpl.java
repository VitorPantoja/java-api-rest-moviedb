package com.movie.catalog.service.impls;

import com.movie.catalog.models.MovieDetails;
import com.movie.catalog.repositories.MovieDetailsRepository;
import com.movie.catalog.service.MovieDetailsService;
import com.movie.catalog.service.dtos.CreateUpdateMovieDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieDetailsServiceImpl implements MovieDetailsService {

    private final MovieDetailsRepository movieDetailsRepository;
    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public MovieDetails save(CreateUpdateMovieDetailsDTO dto) {
        return movieDetailsRepository.saveAndFlush(dto.toEntity());
    }
}
