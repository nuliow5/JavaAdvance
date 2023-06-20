package lt.codeacademy.socialmediaRESTAPI.services;

import lt.codeacademy.socialmediaRESTAPI.dto.CreateCommentDTO;
import lt.codeacademy.socialmediaRESTAPI.dto.UserDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.Comment;
import lt.codeacademy.socialmediaRESTAPI.entities.User;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private UserService userService;

//    public Comment createComment(CreateCommentDTO createCommentDTO){
//        UserDTO userDTO = userService.getUserById(createCommentDTO.getAuthorId());
//
//        Comment comment = new Comment(userDTO, createCommentDTO.getMessage());
//
//        return comment;
//    }
}
