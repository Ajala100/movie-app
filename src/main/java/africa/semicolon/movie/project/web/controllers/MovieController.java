package africa.semicolon.movie.project.web.controllers;

import africa.semicolon.movie.project.data.dtos.MovieDto;
import africa.semicolon.movie.project.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/movie/")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping("movie")
    public ResponseEntity<?> getMovieById(Long id){
        MovieDto savedMovie = movieService.getMovieById(id);
        return ResponseEntity.ok().body(savedMovie.getTitle());
    }
}
