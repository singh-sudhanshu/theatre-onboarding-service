package org.digital.media.model.entity;

public class Reservation {

    private Long reservationId; //PK
    private Long auditoriumId; //FK
    private Long reservationModeId; //FK
    private Long userId;
    private Long moveId;
    private Boolean reserved; // will be used to hold the reservation in cache and release using TTL
    private Boolean paid;
    private Boolean isActive;
}
