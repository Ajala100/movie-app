package africa.semicolon.movie.project.service.movie;

import africa.semicolon.movie.project.data.dtos.MovieDto;
import africa.semicolon.movie.project.data.models.Movie;

import java.util.List;

public interface MovieService {
    MovieDto getMovieById(Long id);
    List<Movie> searchForMoviesByTitle(String title);
    List<Movie> getFavoriteMovies();
    void addMovieToFavorite(MovieDto movieDto);
    void getAllMovies();

}
