package com.movie.catalog.service.dtos;

import com.movie.catalog.models.GenreLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreLanguageDTO {

    Long id;

    String language;

    String genre;

    public static GenreLanguageDTO fromEntity(GenreLanguage genreLanguage) {
        return GenreLanguageDTO.builder()
                .id(genreLanguage.getId())
                .genre(genreLanguage.getGenre().getName())
                .language(genreLanguage.getLanguage().getName())
                .build();
    }
}
