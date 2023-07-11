package lt.codeacademy.socialmediaRESTAPI.mappers;

import lt.codeacademy.socialmediaRESTAPI.dto.UserDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class UserDTOMapper implements Function<User, UserDTO> {

    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getNickName(),
                user.getName(),
                user.getSurName()
        );
    }

}
