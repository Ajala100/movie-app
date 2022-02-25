package africa.semicolon.movie.project.service.User;

import africa.semicolon.movie.project.data.dtos.UserDto;
import africa.semicolon.movie.project.data.models.Movie;
import africa.semicolon.movie.project.data.models.User;
import africa.semicolon.movie.project.data.repostories.MovieRepository;
import africa.semicolon.movie.project.data.repostories.UserRepository;
import africa.semicolon.movie.project.web.exceptions.BusinessLogicException;
import africa.semicolon.movie.project.web.exceptions.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    @Override
    public User createUser(UserDto userDto) throws BusinessLogicException {
        if(userDto == null){
            throw new IllegalArgumentException("Invalid request parameters");
        }
        if(userRepository.findByEmail(userDto.getEmail()).isPresent()){
            throw new BusinessLogicException("User with email " +userDto.getEmail() + "already exits");
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setPassword(userDto.getPassword());
        user.setLastName(userDto.getLastName());

        return userRepository.save(user);
    }

    @Override
    public Movie findMovieByName(String name) throws MovieNotFoundException {
        Optional<Movie> queryResult = movieRepository.findMovieByName(name);
        if(queryResult.isEmpty()){
            throw new MovieNotFoundException("Movie not on our Platform");
        }
        Movie targetMovie = queryResult.get();
        return targetMovie;
    }


}
