package africa.semicolon.movie.project.data.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true )
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fk", referencedColumnName = "id")
    private final Account account;
    private boolean subscription = false;
    private SubscriptionType subscriptionType;

    public User(){
        this.account = new Account();

    }
}
