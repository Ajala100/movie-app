package africa.semicolon.movie.project.web.exceptions;

public class MovieNotFoundException extends Throwable{
    public MovieNotFoundException(String message){
        super(message);
    }
}
