package org.digital.media.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.digital.media.model.ReserveRequest;
import org.digital.media.model.ReserveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ReservationCommandController {

    @ApiOperation(
            value = "Proves the ability to reserve the tickets",
            notes = "This service will accept the theatre object in the request body and creates a new entry in the database.\n\n" +
                    "After successful authentication and authorization the new theatre will be onboarded."
    )

    @ApiResponses({
            @ApiResponse(code = 201, message = "Successfully reserved the seats"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized to perform the action"),
            @ApiResponse(code = 500, message = "Internal Server Error. Unable to serve request at this time. Please try again later.")

    })
    @PostMapping("tickets")
    public ResponseEntity<ReserveResponse> reserveTicket(ReserveRequest ticket) {
        //TODO implement the logic
        return ResponseEntity.ok(new ReserveResponse());
    }
}
