package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Genre;

import com.movie.catalog.models.Genre;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateGenreDTO {

    String name;

    public static CreateUpdateGenreDTO fromEntity(Genre entity){
        return CreateUpdateGenreDTO.builder()
                .name(entity.getName())
                .build();
    }

    public Genre toEntity(){
        return Genre.builder()
                .setName(name)
                .build();
    }

}
