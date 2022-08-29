package com.movie.catalog.service.dtos;

import com.movie.catalog.models.Professional;
import com.movie.catalog.models.ProfessionalAssignment;
import com.movie.catalog.models.enums.MovieSetEnum;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateProfessionalAssignmentDTO {

    Long id;

    MovieSetEnum function;

    Long professionalId;

    public ProfessionalAssignment toEntity() {
        return ProfessionalAssignment.builder()
                .setId(id)
                .setProfessional(Professional.builder().setId(professionalId).build())
                .setFunction(function)
                .build();
    }

    public static CreateUpdateProfessionalAssignmentDTO fromEntity(ProfessionalAssignment dto) {
        return CreateUpdateProfessionalAssignmentDTO.builder()
                .professionalId(dto.getId())
                .function(dto.getFunction())
                .build();
    }

}
