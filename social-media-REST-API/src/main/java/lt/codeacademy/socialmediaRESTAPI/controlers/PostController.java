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
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable long id) {
        return this.postService.getPostById(id);
    }

//    @PostMapping("/create")
//    public Post createPost(@RequestBody long authorId, String title, String body) {
//        return postService.createPost(authorId, title, body);
//    }
//    @PostMapping("/create")
//    public Post createPost(){
//        return postService.createPost();
//    }

    @PostMapping("/comment/{id}")
    public Post addComment(@PathVariable long id, @RequestBody CreateCommentDTO createCommentDTO) {
        try {
            return postService.addComment(id, createCommentDTO);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }

    }

    @DeleteMapping("{id}")
    public Post deletePost(@PathVariable long postId) {
        try {
            return postService.deletePost(postId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
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
