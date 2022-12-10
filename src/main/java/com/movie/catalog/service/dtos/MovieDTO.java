package com.movie.catalog.service.dtos;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.models.Movie;
import com.movie.catalog.models.ProfessionalAssignment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    Long id;

    String name;

    String genre;

    String image;

    String synopsis;

    LocalDateTime releaseDateOf;

    List<ProfessionalAssignment> professionalAssignments;

    List<GenreLanguage> genreLanguages;

    public static MovieDTO fromEntity(Movie movie) {
        return MovieDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .image(movie.getImage())
                .synopsis(movie.getSynopsis())
                .releaseDateOf(movie.getReleaseDateOf())
                .professionalAssignments(new ArrayList<>(movie.getMovieSet()))
                .genreLanguages(new ArrayList<>(movie.getLanguages()))
                .build();
    }
}
