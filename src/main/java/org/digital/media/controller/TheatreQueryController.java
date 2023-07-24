package org.digital.media.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.digital.media.model.Theatre;
import org.digital.media.service.TheatreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class TheatreQueryController {

    private final TheatreService theatreService;

    public TheatreQueryController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @ApiOperation(
            value = "Onboard the new theatre to the platform",
            notes = "This service accepts the theatre id and returns all the details about the theatre"
    )

    @ApiResponses({
            @ApiResponse(code = 200, message = "Theatre found"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized to perform the action"),
            @ApiResponse(code = 500, message = "Internal Server Error. Unable to serve request at this time. Please try again later.")

    })
    @GetMapping("theatres/{id}")
    public ResponseEntity<Theatre> theatre(@PathVariable Long id) {
        //TODO perform the required validations on the input
        return ResponseEntity.ok(theatreService.getTheatre(id));
    }

//    @ApiOperation(
//            value = "Browse the theatres",
//            notes = "Browse theatres currently running the show (movie selected) in the town, " +
//                    "including show timing by a chosen date"
//    )
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "Theatre found"),
//            @ApiResponse(code = 400, message = "Bad Request"),
//            @ApiResponse(code = 401, message = "Unauthorized to perform the action"),
//            @ApiResponse(code = 500, message = "Internal Server Error. Unable to serve request at this time. Please try again later.")
//
//    })
//    /*
//    * select * from movie m , auditorium a
//where m.id = a.movie_id
//and m.id = 2
//    * */
//    @GetMapping("theatres")
//    public ResponseEntity<Theatre> getTheatresByShowAndCity(@RequestParam ) {
//
//
//    }
}
