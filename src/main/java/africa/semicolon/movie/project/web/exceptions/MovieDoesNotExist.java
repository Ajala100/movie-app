package africa.semicolon.movie.project.web.exceptions;

public class MovieDoesNotExist extends BusinessLogicException{
    public MovieDoesNotExist (String message){
        super(message);
    }
}
