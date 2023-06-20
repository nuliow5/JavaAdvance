package lt.codeacademy.socialmediaRESTAPI.controlers;

import lt.codeacademy.socialmediaRESTAPI.dto.PostDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.Post;
import lt.codeacademy.socialmediaRESTAPI.services.PostService;
import lt.codeacademy.socialmediaRESTAPI.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private UserService userService;
    @Autowired
    PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public PostDTO getPostById(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.postService.getPostDTOById(id)).getBody();
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Post by id:%s, not found", id));
        }

    }

    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(postDTO));
    }

    @DeleteMapping("{id}")
    public Post deletePost(@PathVariable long postId) {
        try {
            return ResponseEntity.ok().body(postService.deletePost(postId)).getBody();
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @PutMapping("{id}")
    public PostDTO editPostById(@PathVariable long id, @RequestBody PostDTO postDTO){
        try {
            return ResponseEntity.ok().body(this.postService.updatePostDTOById(id, postDTO)).getBody();
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Post by id:%s, not found", id));
        }

    }

    @PatchMapping("{id}")
    public Post editPost(@PathVariable long postId, @RequestBody long authorId, String newTitle, String newMessage) {
        try {
            return postService.editPost(postId, authorId, newTitle, newMessage);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


    @DeleteMapping("/comments/{id}")
    public Post deleteCommentsFromMyPost(@PathVariable long postId, @RequestBody long authorId, long commentsId) {
        try {
            return postService.deleteCommentsFromMyPost(postId, authorId, commentsId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


}
