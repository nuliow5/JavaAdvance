package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.UserConverter;
import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.entities.User;
import lt.codeacademy.springdataexample.repositories.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public UserDto getUserById(Long id) {
        return UserConverter.convertUserToUserDto(userRepository.findById(id).orElseThrow(() -> new NoSuchElementException()));
    }

    public List<UserDto> getUsers(Pageable pageable) {
        if (pageable != null) {
            return UserConverter.convertUserPageToUserDtoList(userRepository.findAll(pageable));
        }
        return UserConverter.convertUserListToUserDtoList(userRepository.findAll());
    }

    public UserDto createUser(User user) {
        userRepository.save(user);
        return UserConverter.convertUserToUserDto(user);
    }

    public UserDto updateUser(User user) {
        userRepository.save(user);
        return UserConverter.convertUserToUserDto(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
