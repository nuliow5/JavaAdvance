package lt.codeacademy.socialmediaRESTAPI.controlers;

import lt.codeacademy.socialmediaRESTAPI.dto.CreateCommentDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.Post;
import lt.codeacademy.socialmediaRESTAPI.services.PostService;
import lt.codeacademy.socialmediaRESTAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/posts")
public class PostController {

    private UserService userService;

    @Autowired
    PostService postService;
    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable long id){
        return this.postService.getPostById(id);
    }
    @PostMapping
    public Post createPost(@RequestBody long id){
        return postService.createPost(id);
    }

    @PostMapping("/{id}")
    public Post addComment(@PathVariable long id, @RequestBody CreateCommentDTO createCommentDTO){
        try{
            return postService.addComment(id, createCommentDTO);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }
}
