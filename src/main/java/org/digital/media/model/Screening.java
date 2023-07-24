package org.digital.media.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Screening {

    private Integer id; //PK
    private Integer movieId; //FK
    private Integer auditoriumId; //FK
    private LocalDateTime screeningStartTime;

    /*
    * UNIQUE INDEX screening_ak_1 (movie_id,auditorium_id,screening_start_time),
      CONSTRAINT Screening_pk PRIMARY KEY (id)
    * */
}
