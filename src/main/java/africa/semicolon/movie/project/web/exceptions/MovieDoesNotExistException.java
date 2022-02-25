package africa.semicolon.movie.project.web.exceptions;

public class MovieDoesNotExistException extends BusinessLogicException{
    public MovieDoesNotExistException(String message){
        super(message);
    }
}
