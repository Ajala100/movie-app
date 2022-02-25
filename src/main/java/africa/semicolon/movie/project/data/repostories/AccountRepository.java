package africa.semicolon.movie.project.data.repostories;

import africa.semicolon.movie.project.data.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
