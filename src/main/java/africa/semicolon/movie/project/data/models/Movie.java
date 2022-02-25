package africa.semicolon.movie.project.data.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @ElementCollection
    private List<Genre> genre;
    @CreationTimestamp
    private LocalDate yearReleased;
    private LocalDateTime duration;

}
