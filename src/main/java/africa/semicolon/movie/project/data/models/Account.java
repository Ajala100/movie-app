package africa.semicolon.movie.project.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_fk", referencedColumnName = "id")
    private List<Movie> movies;
}
