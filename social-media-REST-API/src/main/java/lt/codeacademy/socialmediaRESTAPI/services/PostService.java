package lt.codeacademy.socialmediaRESTAPI.services;

import lt.codeacademy.socialmediaRESTAPI.dto.CreateCommentDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.Comment;
import lt.codeacademy.socialmediaRESTAPI.entities.Post;

import lt.codeacademy.socialmediaRESTAPI.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    private UserService userService;
    private CommentService commentService;
    private List<Post> posts = new ArrayList<>();

    public List<Post> postSimulate(){
        posts.add(new Post(userService.getUserById(1L), "Post title", "Text body"));
        return posts;
    }

    public List<Post> getAllPosts(){
        if (posts.isEmpty()){
            postSimulate();
        }
        return posts;
    }

    public Post addComment(long postId, CreateCommentDTO createCommentDTO){

        Post commentToPost = getPostById(postId);
        Comment newComment = commentService.createComment(createCommentDTO);
        commentToPost.getComments().add(newComment);

        return commentToPost;
    }

    public Post getPostById(long id){

        Post postById =
                posts.stream()
                        .filter(post -> post.getId().equals(id))
                        .findFirst().orElseThrow(()->{throw new NoSuchElementException(String.format("Post by id: {%s} not found", id));
                        });
        return postById;
    }

    public Post createPost(long postAuthorId){
        User user = userService.getUserById(postAuthorId);
        return new Post(user, "Title", "Test Body");
    }

}

