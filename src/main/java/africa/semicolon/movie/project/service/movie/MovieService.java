package africa.semicolon.movie.project.service.movie;

import africa.semicolon.movie.project.data.dtos.MovieDto;
import africa.semicolon.movie.project.data.models.Movie;
import africa.semicolon.movie.project.web.exceptions.BusinessLogicException;
import africa.semicolon.movie.project.web.exceptions.MovieDoesNotExistException;

import java.util.List;

public interface MovieService {
    MovieDto getMovieById(Long id)throws MovieDoesNotExistException;
    List<Movie> searchForMoviesByTitle(String title) throws BusinessLogicException;
    List<Movie> getFavoriteMovies();
    void addMovieToFavorite(MovieDto movieDto);
    List<Movie> getAllMovies() throws BusinessLogicException;

}
