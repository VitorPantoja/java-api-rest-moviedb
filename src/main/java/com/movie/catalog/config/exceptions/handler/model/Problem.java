package com.movie.catalog.config.exceptions.handler.model;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "set")
public class Problem {
  private String message;
  private String title;
  private Date dateTime;
  private List<Fields> fields;
}
