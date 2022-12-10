package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Movie;
import com.movie.catalog.service.validations.ValidMovie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateMovieDTO {

    @ValidMovie
    Long id;

    @NotNull(message = "O nome do filme é obrigatório!")
    String name;

    String image;

    String synopsis;

    @NotNull(message = "A data de lançamaneto é obrigatória!")
    LocalDateTime releaseDateOf;

    List<@Valid CreateUpdateProfessionalAssignmentDTO> professionalAssignmentDTOS;

    List<@Valid CreateUpdateGenreLanguageDTO> genreLanguagesDTOS;

    public Movie toEntity() {
        var movie = Movie.builder()
                .setId(id)
                .setName(name)
                .setSynopsis(synopsis)
                .setReleaseDateOf(releaseDateOf)
                .setImage(image)
                .build();
        if (nonNull(professionalAssignmentDTOS)) {
            movie.setMovieSet(professionalAssignmentDTOS.stream().map(dto -> {
                var professional = dto.toEntity();
                professional.setMovie(movie);
                return professional;
            }).collect(Collectors.toSet()));
        }

        if (nonNull(genreLanguagesDTOS)) {
            movie.setLanguages(genreLanguagesDTOS.stream().map(dto -> {
                var genreLanguage = dto.toEntity();
                genreLanguage.setMovie(movie);
                return genreLanguage;
            }).collect(Collectors.toSet()));
        }
        return movie;
    }

}
