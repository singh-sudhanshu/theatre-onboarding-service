package org.digital.media.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long movieId;
    private Integer numberOfSeats;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "auditorium_id", referencedColumnName = "id")
    private List<Seat> seats;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "theatre_id", referencedColumnName = "id")
    private Theatre theatre;
}
