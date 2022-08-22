package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Genre;
import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.models.Language;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateGenreLanguageDTO {

    Long id;

    Long genreId;

    Long languageId;

    public GenreLanguage toEntity() {
        return GenreLanguage.builder()
                .setId(id)
                .setGenre(Genre.builder().setId(genreId).build())
                .setLanguage(Language.builder().setId(languageId).build())
                .build();
    }

}
