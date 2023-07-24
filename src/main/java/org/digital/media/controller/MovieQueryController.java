package org.digital.media.controller;

import org.digital.media.model.Movie;
import org.digital.media.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieQueryController {

    private final MovieService movieService;

    @Autowired
    public MovieQueryController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public ResponseEntity<List<Movie>> getMovies(@RequestParam String city, @RequestParam String language, @RequestParam String genre) {
        var response = movieService.service(city, language, genre);
        return ResponseEntity.ok(response);
    }
}
