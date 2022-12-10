package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Genre;
import com.movie.catalog.models.GenreLanguage;
import com.movie.catalog.models.Language;
import com.movie.catalog.service.validations.ValidGenre;
import com.movie.catalog.service.validations.ValidLanguage;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateGenreLanguageDTO {

    Long id;

    @ValidGenre
    @NotNull(message = "o gênero é obrigatório!")
    Long genreId;

    @ValidLanguage
    @NotNull(message = "A linguagem é obrigatória!")
    Long languageId;

    public GenreLanguage toEntity() {
        return GenreLanguage.builder()
                .setId(id)
                .setGenre(Genre.builder().setId(genreId).build())
                .setLanguage(Language.builder().setId(languageId).build())
                .build();
    }

}
