package org.digital.media.connector;

import org.digital.media.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>  {

    //TODO can implement pagination here to achieve the performance. May return 100 results

    @Query(value = "select * from Movie m where m.language = :language or m.genre = :genre", nativeQuery = true)
    List<Movie> findByLanguageAndGenre(String language, String genre);
}
