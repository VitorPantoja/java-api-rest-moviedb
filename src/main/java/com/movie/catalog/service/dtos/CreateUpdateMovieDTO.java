package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Movie;
import com.movie.catalog.models.MovieDetails;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateMovieDTO {

    Long id;

    String name;

    List<CreateUpdateProfessionalAssignmentDTO> professionalAssignmentDTOS;

    CreateUpdateMovieDetailsDTO movieDetailsDTO;

    public Movie toEntity() {
        var movie = Movie.builder()
                .setId(id)
                .setName(name)
                .setMovieDetails(movieDetailsDTO.toEntity())
                .build();
        movie.getMovieDetails().getLanguages().stream().map(l -> {
            l.setMovieDetails(movie.getMovieDetails());
            return null;
        });

        if (nonNull(professionalAssignmentDTOS)){
            movie.setMovieSet(professionalAssignmentDTOS.stream().map(p -> {
                var professionalAssignment = p.toEntity();
                professionalAssignment.setMovie(movie);
                return professionalAssignment;
            }).collect(Collectors.toSet()));
        } else {
            movie.setMovieSet(new HashSet<>());
        }
//        if (nonNull(movieDetailsDTO.getGenreDTO())) {
//            var movieDetails = movieDetailsDTO.toEntity();
//            movieDetails.getLanguages().stream().map(l -> {
//                l.setMovieDetails(movieDetails);
//                return null;
//            });
//            movie.setMovieDetails(movieDetails);
//        } else {
//            movie.setMovieDetails(MovieDetails.builder().build());
//        }
        return movie;
    }


}
