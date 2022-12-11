package com.movie.catalog.service.dtos;

import com.movie.catalog.models.ProfessionalAssignment;
import com.movie.catalog.models.enums.MovieSetEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessionalAssignmentDTO {
    private Long id;

    private String professional;

    private MovieSetEnum function;

    public static ProfessionalAssignmentDTO fromEntity(ProfessionalAssignment professionalAssignment) {
        return ProfessionalAssignmentDTO.builder()
                .id(professionalAssignment.getId())
                .professional(professionalAssignment.getProfessional().getName())
                .function(professionalAssignment.getFunction())
                .build();
    }
}
