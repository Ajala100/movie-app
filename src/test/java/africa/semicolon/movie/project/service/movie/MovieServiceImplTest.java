package africa.semicolon.movie.project.service.movie;

import africa.semicolon.movie.project.data.dtos.MovieDto;
import africa.semicolon.movie.project.web.exceptions.MovieDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
//@Sql(scripts="/insert.sql")
class MovieServiceImplTest {

    @Autowired
    private MovieService movieService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getMovieById() throws MovieDoesNotExistException {
        MovieDto movieDto = movieService.getMovieById(550L);
        log.info("Title of movie dto is {}", movieDto.getTitle());
        assertThat(movieDto.getTitle()).isEqualTo("Fight Club");
    }

    @Test
    public void searchForMoviesByTitle() {
    }

    @Test
    public void getAllMovies() {
    }
}