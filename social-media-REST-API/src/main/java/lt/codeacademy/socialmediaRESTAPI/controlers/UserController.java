package lt.codeacademy.socialmediaRESTAPI.controlers;

import lt.codeacademy.socialmediaRESTAPI.dto.UserDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.User;
import lt.codeacademy.socialmediaRESTAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.String.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers(){
        return this.userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.userService.getUserDTOById(id)).getBody();
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User by id:%s, not found", id));
        }
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable long id, @RequestBody UserDTO userDTO){
        try{
            return ResponseEntity.ok().body(this.userService.updateUserDTOById(id, userDTO));
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User by id:%s, not found", id));
        }

    }

}
