package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Language;
import com.movie.catalog.models.enums.LanguageEnum;
import com.movie.catalog.service.validations.ValidLanguage;
import com.movie.catalog.service.validations.ValidLanguageName;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {

    @ValidLanguage
    Long id;

    @NotNull(message = "O idioma é obrigatório!")
    @ValidLanguageName
    String name;

    @NotNull(message = "A tag é obrigatória!")
    LanguageEnum tag;

    public Language toEntity(){
        return Language.builder()
                .setId(id)
                .setName(name)
                .setTag(tag)
                .build();
    }
    public static LanguageDTO fromEntity(Language entity) {
        return LanguageDTO.builder()
                .id(entity.getId())
                .tag(entity.getTag())
                .name(entity.getName())
                .build();
    }
}
