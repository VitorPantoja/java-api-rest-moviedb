package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Genre;
import com.movie.catalog.models.Language;
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
public class CreateUpdateMovieDetailsDTO {

    Long id;

    List<CreateUpdateGenreLanguageDTO> genreDTO;

    public MovieDetails toEntity(){
        return MovieDetails.builder()
                .setId(id)
                .setLanguages(genreDTO.stream().map(CreateUpdateGenreLanguageDTO::toEntity).collect(Collectors.toSet()))
                .build();
    }

//    public static CreateUpdateMovieDetailsDTO fromEntity(MovieDetails entity){
//        return CreateUpdateMovieDetailsDTO
//                .builder()
//                .genreDTO(entity.getGenres().stream().map(CreateUpdateGenreDTO::fromEntity).collect(Collectors.toList()))
//                .languageId(entity.getLanguages().stream().map(Language::getId).collect(Collectors.toList()))
//                .build();
//    }

}