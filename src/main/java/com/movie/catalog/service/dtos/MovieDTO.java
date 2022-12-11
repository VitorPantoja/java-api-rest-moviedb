package com.movie.catalog.service.dtos;

import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.models.Movie;
import com.movie.catalog.models.ProfessionalAssignment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
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

    List<@Valid ProfessionalAssignment> professionalAssignments;

    List<@Valid GenreLanguage> genreLanguages;

    public static MovieDTO fromEntity(Movie movie) {
        var genres = movie.getLanguages().stream().map(genreLanguage -> genreLanguage.getGenre().getName()).reduce("",(partialString, genre) -> partialString + genre + ", ");
        genres = genres.substring(0, genres.length() - 2);
        return MovieDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .image(movie.getImage())
                .synopsis(movie.getSynopsis())
                .releaseDateOf(movie.getReleaseDateOf())
                .genre(genres)
                .professionalAssignments(new ArrayList<>(movie.getMovieSet()))
                .genreLanguages(new ArrayList<>(movie.getLanguages()))
                .build();
    }
}
