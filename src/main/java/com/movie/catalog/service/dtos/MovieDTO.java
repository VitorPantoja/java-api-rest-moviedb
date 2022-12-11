package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

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

    LocalDate releaseDateOf;

    List<@Valid ProfessionalAssignmentDTO> professionalAssignments;

    List<@Valid GenreLanguageDTO> genreLanguages;

    public static MovieDTO fromEntity(Movie movie) {
        var genres = movie.getLanguages().stream().map(genreLanguage -> genreLanguage.getGenre().getName()).reduce("",(partialString, genre) -> partialString + genre + ", ");
        genres = genres.substring(0, genres.length() - 2);
        return MovieDTO.builder()
                .id(movie.getId())
                .name(movie.getName())
                .image(movie.getImage())
                .synopsis(movie.getSynopsis())
                .releaseDateOf(nonNull(movie.getReleaseDateOf()) ?
                        LocalDate.of(movie.getReleaseDateOf().getYear(), movie.getReleaseDateOf().getMonth().getValue(),
                                movie.getReleaseDateOf().getDayOfMonth()) : null)
                .genre(genres)
                .professionalAssignments(movie.getMovieSet().stream()
                        .map(ProfessionalAssignmentDTO::fromEntity).collect(Collectors.toList()))
                .genreLanguages(movie.getLanguages().stream()
                        .map(GenreLanguageDTO::fromEntity).collect(Collectors.toList()))
                .build();
    }
}
