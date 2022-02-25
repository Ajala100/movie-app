package africa.semicolon.movie.project.data.repostories;

import africa.semicolon.movie.project.data.models.Genre;
import africa.semicolon.movie.project.data.models.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MovieRepositoryTest {

    @Autowired
    MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Test that Movie can be saved to database")
    void saveMovieToDatabaseTest(){

        //create movie
        Movie movie = new Movie();
        List<Genre> genre = new ArrayList<>();
        genre.add(Genre.ROMANCE);
        genre.add(Genre.ACTION);
        genre.add(Genre.KIDS);
        movie.setGenre(genre);
        movie.setName("Coming to America");
        movie.setId(2L);

        //save movie
        movieRepository.save(movie);

        //check that movie is saved in database
        assertThat(movieRepository.findAll()).isNotNull();
        assertThat(movieRepository.findById(2L)).isNotNull();


    }
    @Test
    @DisplayName("Test that movie can be found by name")
    void findMovieByName() {
        //create movie
        Movie movie = new Movie();
        List<Genre> genre = new ArrayList<>();
        genre.add(Genre.ROMANCE);
        genre.add(Genre.ACTION);
        genre.add(Genre.KIDS);
        movie.setGenre(genre);
        movie.setName("Half of a yellow sun");

        //save movie
        movieRepository.save(movie);
        assertThat(movieRepository.findMovieByName("Half of a yellow sun")).isNotNull();

    }
}