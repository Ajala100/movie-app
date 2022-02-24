package africa.semicolon.movie.project.data.repostories;

import africa.semicolon.movie.project.data.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByName(String name);
}
