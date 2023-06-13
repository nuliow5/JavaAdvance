package lt.codeacademy.socialmediaRESTAPI.services;

import lombok.Setter;
import lt.codeacademy.socialmediaRESTAPI.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> simulateUsersCreates(){
        users.add(new User("Kebabas77", "Laurynas", "Laurynaitis", LocalDate.of(1985, 7,16), "Kebabas77@gmail.com"));
        users.add(new User("B3bR45", "Saulius", "Sulenas", LocalDate.of(1995, 6,18), "B3bR45@gmail.com"));
        users.add(new User("777TT", "Donatas", "Dautvydas", LocalDate.of(2001, 5,26), "777TT@gmail.com"));
        users.add(new User("IZZI", "Lina", "Lizaura", LocalDate.of(1999, 4,17), "IZZI@gmail.com"));

        return users;
    }



    public List<User> getAllUsers(){
        if (users.isEmpty()){
            simulateUsersCreates();
        }
        return users;
    }

    public User getUserById(Long id) {
        User userById =
                this.users.stream()
                        .filter(user -> user.getId().equals(id))
                        .findFirst().orElseThrow(()->{throw new NoSuchElementException(String.format("User by id: {%s} not found", id));
                        });
        return userById;
    }
}
