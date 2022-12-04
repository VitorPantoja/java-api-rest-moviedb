package com.movie.catalog.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.movie.catalog.models.enums.MovieSetEnum;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class ProfessionalAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "SERIAL", updatable = false, nullable = false, unique = true)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MovieSetEnum function;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "professional_id")
    private Professional professional;
}
