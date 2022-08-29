package com.movie.catalog.service.dtos;

import com.movie.catalog.models.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateMovieDTO {

    Long id;

    String name;

    List<CreateUpdateProfessionalAssignmentDTO> professionalAssignmentDTOS;

    List<CreateUpdateGenreLanguageDTO> genreLanguagesDTOS;

    public Movie toEntity() {
        var movie = Movie.builder()
                .setId(id)
                .setName(name)
                .build();
        if (nonNull(professionalAssignmentDTOS)) {
            movie.setMovieSet(professionalAssignmentDTOS.stream().map(dto ->{
                var professional = dto.toEntity();
                professional.setMovie(movie);
                return professional;
            }).collect(Collectors.toSet()));
        }

        if (nonNull(genreLanguagesDTOS)) {
            movie.setLanguages(genreLanguagesDTOS.stream().map(dto -> {
                var genreLAnguage = dto.toEntity();
                genreLAnguage.setMovie(movie);
                return genreLAnguage;
            }).collect(Collectors.toSet()));
        }
        return movie;
    }


}
