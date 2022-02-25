package africa.semicolon.movie.project.data.repostories;

import africa.semicolon.movie.project.data.dtos.UserDto;
import africa.semicolon.movie.project.data.models.User;
import africa.semicolon.movie.project.web.exceptions.BusinessLogicException;
import africa.semicolon.movie.project.web.exceptions.UserDoesNotExistException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void findByEmail() {
    }

    @Test
    @DisplayName("TEst that user can be created test")
    void createUSer(){

        //create user
        User user = new User();
        user.setEmail("ahmad@gmail.com");
        user.setFirstName("Ahmad");
        user.setLastName("Ajala");
        user.setPassword("password");

        //save user
        userRepository.save(user);

        //check that user was successfully saved
        assertThat(userRepository.findAll()).isNotNull();
        User targetUser = userRepository.findByEmail("ahmad@gmail.com").orElse(null);
        assertThat(targetUser.getId()).isNotNull();
        assertThat(targetUser.getLastName()).isEqualTo(user.getLastName());
    }

    @Test
    @DisplayName("Test that user details can be updated")
    void updateUserDetails() throws BusinessLogicException {

        //create user
        User user = new User();
        user.setEmail("bola@gmail.com");
        user.setFirstName("Kola");
        user.setLastName("Tolu");
        user.setPassword("password");

        //save user
        userRepository.save(user);


        //create userDto
        UserDto userDto = new UserDto();
        userDto.setEmail("ozy@gmail.com");
        userDto.setFirstName("Jerry");
        userDto.setLastName("Goodnews");
        userDto.setPassword("passwordd");

        //get user to be updated
        User targetUser = userRepository.findByEmail("bola@gmail.com").orElse(null);

        //update user
        targetUser.setFirstName(userDto.getFirstName());
        targetUser.setLastName(userDto.getLastName());

        //save user to database

        userRepository.save(targetUser);

        //check that update was successfull
        assertThat(targetUser.getFirstName()).isEqualTo(userDto.getFirstName());

    }

    @Test
    @DisplayName("Test that user can be deleted by Id")
    public void userCanBeDeleted(){
        //create user
        User user = new User();
        user.setEmail("bola@gmail.com");
        user.setFirstName("Kola");
        user.setLastName("Tolu");
        user.setPassword("password");

        //save user
        userRepository.save(user);

        User queryResult = userRepository.findByEmail(user.getEmail()).orElse(null);
        userRepository.delete(queryResult);

        //check that user was deleted
        Optional<User> user1 = userRepository.findByEmail(queryResult.getEmail());
        User targetUser = user1.get();
        assertThat(targetUser).isNull();
    }

    private User applyPatchToUSer(JsonPatch userPatch, User targetUser) throws JsonProcessingException, JsonPatchException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = userPatch.apply(objectMapper.convertValue(targetUser, JsonNode.class));
        return objectMapper.treeToValue(patched, User.class);
    }

}