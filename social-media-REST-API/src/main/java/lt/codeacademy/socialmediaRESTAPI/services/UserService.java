package lt.codeacademy.socialmediaRESTAPI.services;

import lt.codeacademy.socialmediaRESTAPI.dto.UserDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.User;
import lt.codeacademy.socialmediaRESTAPI.mappers.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();
    @Autowired
    UserDTOMapper userDTOMapper;



    public List<User> simulateUsersCreates(){
        users.add(new User("Kebabas77", "Laurynas", "Laurynaitis", LocalDate.of(1985, 7,16), "Kebabas77@gmail.com"));
        users.add(new User("B3bR45", "Saulius", "Sulenas", LocalDate.of(1995, 6,18), "B3bR45@gmail.com"));
        users.add(new User("777TT", "Donatas", "Dautvydas", LocalDate.of(2001, 5,26), "777TT@gmail.com"));
        users.add(new User("IZZI", "Lina", "Lizaura", LocalDate.of(1999, 4,17), "IZZI@gmail.com"));

        return users;
    }

    public UserDTO createUser(UserDTO userDTO){

//        userDTOMapper.apply(userDTO);
        return null;
    }



    public List<UserDTO> getAllUsers(){
        if (users.isEmpty()){
            simulateUsersCreates();
        }
        return users
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public UserDTO getUserDTOById(Long id) {
        User userById =
                this.users.stream()
                        .filter(user -> user.getId().equals(id))
                        .findFirst().orElseThrow(()->{
                            throw new NoSuchElementException(String.format("User by id: {%s} not found", id));
                        });
        return userDTOMapper.apply(userById);
    }

    public User getUserById(Long id){
        User userById =
                this.users.stream()
                        .filter(user -> user.getId().equals(id))
                        .findFirst().orElseThrow(()->{
                            throw new NoSuchElementException(String.format("User by id: {%s} not found", id));
                        });
        return userById;
    }

    public List<User> updateUserById(long id, UserDTO userDTO){
        User newUser = getUserById(id);
        int indexOfUser = this.users.indexOf(newUser);
        this.users.set(indexOfUser, new User(newUser, userDTO));
        return this.users;
    }

    public UserDTO updateUserDTOById(long id, UserDTO userDTO){
        User updatingUser = getUserById(id);
        updatingUser.setNickName(userDTO.nickName());
        updatingUser.setName(userDTO.name());
        updatingUser.setSurName(userDTO.surName());

        return userDTO;
    }

}
