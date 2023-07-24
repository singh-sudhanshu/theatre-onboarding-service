package org.digital.media.service;

import org.digital.media.connector.TheatreRepository;
import org.digital.media.exception.TheatreNotFoundException;
import org.digital.media.model.Theatre;
import org.digital.media.model.TheatreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public TheatreResponse service(Theatre theatre) {
        var response = theatreRepository.save(theatre);
        return TheatreResponse.builder()
                .code(201)
                .message("Theatre has been onboarded successfully with id: " + response.getId())
                .build();
    }

    public Theatre getTheatre(Long id) {
        var response = theatreRepository.findById(id);
        if (response.isEmpty()) {
            throw new TheatreNotFoundException("Unable to find theatre for given id: " + id);
        }
        return response.get();
    }
}
