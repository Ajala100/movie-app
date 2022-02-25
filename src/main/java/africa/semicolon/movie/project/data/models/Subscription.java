package africa.semicolon.movie.project.data.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private SubscriptionType type;
    private Double amount;
}
