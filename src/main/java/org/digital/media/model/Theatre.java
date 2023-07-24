package org.digital.media.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Getter
@Builder
@Table(name = "THEATRE")
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String city;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private List<Auditorium> auditoriums;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private List<Movie> movies;

    /*
     * Methods
     * isOpen
     * displayMovie
     * */

}
