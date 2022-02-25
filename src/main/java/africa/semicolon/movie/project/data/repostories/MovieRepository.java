package africa.semicolon.movie.project.data.repostories;

import africa.semicolon.movie.project.data.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
