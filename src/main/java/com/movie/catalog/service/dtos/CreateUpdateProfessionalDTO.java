package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Professional;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateProfessionalDTO {

    Long id;

    String name;

    public Professional toEntity() {
        return Professional.builder()
            .setId(id)
            .setName(name)
            .build();
    }

    public static CreateUpdateProfessionalDTO fromEntity(Professional entity) {
        return CreateUpdateProfessionalDTO.builder()
                .name(entity.getName())
                .build();
    }

}
