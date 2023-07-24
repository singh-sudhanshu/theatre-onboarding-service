package org.digital.media.model;

/*
* The SeatReserved table enables us to make a reservation for one or multiple seats.
* If the seats are available, one record would be added to this table for each of them.
*  If we want to check which seats are free or taken we can check the values in this table
* joined to the reservation table where reservation.active = True.
* */

public class SeatReserved {

    private Long id;
    private Long seatId;
    private Long reservationId;
    private Long auditoriumId;
}
