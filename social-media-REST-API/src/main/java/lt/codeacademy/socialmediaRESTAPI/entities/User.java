package lt.codeacademy.socialmediaRESTAPI.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.socialmediaRESTAPI.dto.UserDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;
    private String nickName;
    private String name;
    private String surName;
    private LocalDate birthDate;
    private String email;
    private LocalDateTime createdUser;
    private static Long idIncrementor = 1L;

    public User(String nickName, String name, String surName, LocalDate birthDate, String email) {
        this.id = idIncrementor;
        this.nickName = nickName;
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.email = email;
        this.createdUser = LocalDateTime.now();
        idIncrementor++;
    }

    public User(User oldUser, UserDTO newUser){
        this.id = oldUser.getId();
        this.nickName = newUser.nickName();
        this.name = newUser.name();
        this.surName = newUser.surName();
        this.birthDate = oldUser.getBirthDate();
        this.email = oldUser.getEmail();
        this.createdUser = oldUser.getCreatedUser();

    }
}
