package org.digital.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "MOVIE")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String genre;
    private String language;
    private Integer durationInMinutes;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;
}
