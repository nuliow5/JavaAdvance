package lt.codeacademy.socialmediaRESTAPI.mappers;

import lt.codeacademy.socialmediaRESTAPI.dto.UserDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserDTOMapper2 {
    public static long userid = 1;
//    public User fromDTO(UserDTO userDTO){
//        User user = new User(
//                this.userid++,
//                userDTO.nickName(),
//                userDTO.name(),
//                userDTO.surName(),
//
//                );
//    }

    public UserDTO fromUser(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getNickName(),
                user.getName(),
                user.getSurName()
        );

        return userDTO;
    }

}
