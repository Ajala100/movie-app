package africa.semicolon.movie.project.service.movie;

import africa.semicolon.movie.project.data.dtos.MovieDto;
import africa.semicolon.movie.project.data.models.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{
    @Override
    public MovieDto getMovieById(Long id) {
        String url = String.format("http://api.themoviedb.org/3/movie/%d?api-key=5fe726b69eafac315d8d6f40e1970e7a",id);
        RestTemplate restTemplate = new RestTemplate();
        Movie returnedMovie= restTemplate.getForObject(url, Movie.class);

        assert returnedMovie != null;
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
    public List<Movie> searchForMoviesByTitle(String title) {
        return null;
    }

    @Override
    public List<Movie> getFavoriteMovies() {
        return null;
    }

    @Override
    public void addMovieToFavorite(MovieDto movieDto) {

    }

    @Override
    public void getAllMovies() {

    }
}
