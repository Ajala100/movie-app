package africa.semicolon.movie.project.web.controllers;

import africa.semicolon.movie.project.data.dtos.MovieDto;
import africa.semicolon.movie.project.data.models.Movie;
import africa.semicolon.movie.project.service.movie.MovieService;
import africa.semicolon.movie.project.web.exceptions.BusinessLogicException;
import africa.semicolon.movie.project.web.exceptions.MovieDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/movie/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id){
        try {
            MovieDto savedMovie = movieService.getMovieById(id);
            return ResponseEntity.ok().body(savedMovie.getTitle());

        } catch (MovieDoesNotExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("movies")
    public ResponseEntity<?> getAllMovies(){
        try {
            List<Movie> movies = movieService.getAllMovies();
            return ResponseEntity.ok().body(movies);
        }
        catch (BusinessLogicException exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("movies-query")
    public ResponseEntity<?> searchForMovie(@RequestBody String query){

        try{
            List<Movie> movies = movieService.searchForMoviesByTitle(query);
            return ResponseEntity.ok().body(movies);
        } catch (BusinessLogicException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
