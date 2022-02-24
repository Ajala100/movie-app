package africa.semicolon.movie.project.data.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Genre genre;
    @CreationTimestamp
    private LocalDate yearReleased;
    private LocalDateTime duration;
    private String posterPath;
    private String title;
    private Boolean adult;
    private String overview;
    private String mediaType;

}
