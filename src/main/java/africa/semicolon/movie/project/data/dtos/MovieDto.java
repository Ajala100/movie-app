package africa.semicolon.movie.project.data.dtos;
import africa.semicolon.movie.project.data.models.Genre;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class MovieDto {
    private Long id;
    private Genre genre;
    @CreationTimestamp
    private LocalDate yearReleased;
    private LocalDateTime duration;
    private String posterPath;
    private String title;
    private Boolean adult;
    private String mediaType;
    private String overview;


}