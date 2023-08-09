package org.digital.media.service;

import org.digital.media.connector.MovieRepository;
import org.digital.media.model.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> service(String city, String language, String genre) {
        var response = movieRepository.findByLanguageAndGenre(language, genre);
        var res =  response.stream().filter( i -> i.getTheatre().getCity().equalsIgnoreCase(city)).toList();
        return res;
    }
}
