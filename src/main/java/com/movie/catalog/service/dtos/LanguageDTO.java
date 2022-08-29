package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Language;
import com.movie.catalog.models.enums.LanguageEnum;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDTO {

    Long id;

    String name;

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
