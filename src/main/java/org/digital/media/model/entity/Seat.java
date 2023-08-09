package org.digital.media.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer rowNumber;
//    private Boolean isAvailable;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "auditorium_id", referencedColumnName = "id")
    private Auditorium auditoriums;
}
