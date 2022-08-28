package com.movie.catalog.service.dtos;

import com.movie.catalog.models.*;
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
         var movieDetails= MovieDetails.builder()
                .setId(id)
                .build();
        if (nonNull(genreDTO)) {
            movieDetails.setLanguages(genreDTO.stream().map(l -> GenreLanguage.builder()
                    .setId(l.getId())
                    .setGenre(Genre.builder().setId(l.getGenreId()).build())
                    .setLanguage(Language.builder().setId(l.getLanguageId()).build())
                    .setMovieDetails(movieDetails)
                    .build()).collect(Collectors.toSet()));
        }

        return movieDetails;
    }

//    public static CreateUpdateMovieDetailsDTO fromEntity(MovieDetails entity){
//        return CreateUpdateMovieDetailsDTO
//                .builder()
//                .genreDTO(entity.getGenres().stream().map(CreateUpdateGenreDTO::fromEntity).collect(Collectors.toList()))
//                .languageId(entity.getLanguages().stream().map(Language::getId).collect(Collectors.toList()))
//                .build();
//    }

}