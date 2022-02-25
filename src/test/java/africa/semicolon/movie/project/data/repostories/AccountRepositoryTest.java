package africa.semicolon.movie.project.data.repostories;

import africa.semicolon.movie.project.data.models.Account;
import africa.semicolon.movie.project.data.models.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AccountRepositoryTest {

    @Autowired
    UserRepository userRepository;


    @Test
    @DisplayName("Create a new user with account test")
    void whenNewUserIsCreated_AccountIsCreatedTest(){

        //create new user
        User user = new User();
        user.setEmail("ozi@gmail.com");
        user.setPassword("ahmad");
        user.setFirstName("goodnews");
        user.setFirstName("jerry");

        //save new user
        userRepository.save(user);

        //check that account was created
        User targetUser = userRepository.findByEmail("ozi@gmail.com").orElse(null);
        assertThat(targetUser.getId()).isNotNull();
        assertThat(targetUser.getAccount()).isNotNull();

    }

}