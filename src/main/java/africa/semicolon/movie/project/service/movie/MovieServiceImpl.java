package africa.semicolon.movie.project.service.movie;

import africa.semicolon.movie.project.data.dtos.MovieDto;
import africa.semicolon.movie.project.data.models.Movie;
import africa.semicolon.movie.project.web.exceptions.BusinessLogicException;
import africa.semicolon.movie.project.web.exceptions.MovieDoesNotExistException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Override
    public MovieDto getMovieById(Long id) throws MovieDoesNotExistException {
        String apikey = "5fe726b69eafac315d8d6f40e1970e7a";

        String url = "http://api.themoviedb.org/3/movie/550?api-key=5fe726b69eafac315d8d6f40e1970e7a";
        RestTemplate restTemplate = new RestTemplate();
        Movie returnedMovie= restTemplate.getForObject(url, Movie.class);
        if ( returnedMovie == null ) throw new MovieDoesNotExistException("This movie with id "+id+" is not available");
        return map(returnedMovie);
    }

    private MovieDto map(Movie returnedMovie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(returnedMovie.getId());
        movieDto.setAdult(returnedMovie.getAdult());
        movieDto.setDuration(returnedMovie.getDuration());
        movieDto.setGenre(returnedMovie.getGenre());
        movieDto.setOverview(returnedMovie.getOverview());
        movieDto.setMediaType(returnedMovie.getMediaType());
        movieDto.setTitle(returnedMovie.getTitle());
        movieDto.setPosterPath(returnedMovie.getPosterPath());
        movieDto.setYearReleased(returnedMovie.getYearReleased());
        return movieDto;
    }

    @Override
    public List<Movie> searchForMoviesByTitle(String query) throws BusinessLogicException {
        String apikey = "5fe726b69eafac315d8d6f40e1970e7a";

        String url = String.format
                ("https://api.themoviedb.org/3/search/movie?api_key=%s&language=en-US&query=%s&page=1&include_adult=false",
                        apikey, query);

        RestTemplate restTemplate = new RestTemplate();

        Movie [] movies = restTemplate.getForObject(url, Movie[].class);
        if ( movies == null ) throw new BusinessLogicException
                ("There are no movies with matching query!");

        return Arrays.asList(movies);
    }

    @Override
    public List<Movie> getAllMovies() throws BusinessLogicException {
        String apikey = "5fe726b69eafac315d8d6f40e1970e7";
        String url = String.format
                ("https://api.themoviedb.org/3/discover/movie?api_key=%sa&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate",
                        apikey);
        RestTemplate restTemplate = new RestTemplate();
        Movie[] movies = restTemplate.getForObject(url, Movie[].class);

        if ( movies == null ) throw new BusinessLogicException
                ("There are no movies available right now!");

        return Arrays.asList(movies);
    }


    @Override
    public List<Movie> getFavoriteMovies() {
        return null;
    }

    @Override
    public void addMovieToFavorite(MovieDto movieDto) {

    }

}
