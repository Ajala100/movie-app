package africa.semicolon.movie.project.data.models;

import lombok.Data;

import javax.persistence.*;

@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String LastName;
    @Column(nullable = false, unique = true )
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "User-fk", referencedColumnName = "id")
    private final Account account;
    private boolean subscription = false;

    public User(){
        this.account = new Account();

    }
}
