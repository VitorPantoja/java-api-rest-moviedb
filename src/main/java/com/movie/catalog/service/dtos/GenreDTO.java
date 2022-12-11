package com.movie.catalog.service.dtos;

import com.movie.catalog.service.validations.ValidGenreName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {

    @ValidGenreName
    String name;
}
