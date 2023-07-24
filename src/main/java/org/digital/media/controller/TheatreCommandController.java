package org.digital.media.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.digital.media.model.Theatre;
import org.digital.media.model.TheatreResponse;
import org.digital.media.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class TheatreCommandController {

    private final TheatreService theatreService;

    @Autowired
    public TheatreCommandController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @ApiOperation(
            value = "Onboard the new theatre to the platform",
            notes = "This service will accept the theatre object in the request body and creates a new entry in the database.\n\n" +
                    "After successful authentication and authorization the new theatre will be onboarded."
    )

    @ApiResponses({
            @ApiResponse(code = 201, message = "Successfully onboarded the theatre"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized to perform the action"),
            @ApiResponse(code = 500, message = "Internal Server Error. Unable to serve request at this time. Please try again later.")

    })
    @PostMapping(value = "theatres",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TheatreResponse> theatreResponse(@RequestBody Theatre theatre) {
        //TODO perform the required validations on the input
        return ResponseEntity.ok(theatreService.service(theatre));
    }
}
