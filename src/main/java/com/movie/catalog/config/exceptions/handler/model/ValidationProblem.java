package com.movie.catalog.config.exceptions.handler.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
public class ValidationProblem {
  private String field;
  private String message;
}
