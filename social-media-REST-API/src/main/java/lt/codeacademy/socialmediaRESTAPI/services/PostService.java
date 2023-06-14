package lt.codeacademy.socialmediaRESTAPI.services;

import lt.codeacademy.socialmediaRESTAPI.dto.CreateCommentDTO;
import lt.codeacademy.socialmediaRESTAPI.dto.CreatePostDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.Comment;
import lt.codeacademy.socialmediaRESTAPI.entities.Post;

import lt.codeacademy.socialmediaRESTAPI.entities.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    private UserService userService;
    private CommentService commentService;
    private List<Post> posts = new ArrayList<>();

    public List<Post> postSimulate(){
        posts.add(new Post(new User(
                "demo000",
                "demoName",
                "demoSurname",
                LocalDate.of(1985, 7,20),
                "demo0000@gmail.com"
        ), "Post title", "Text body"));
        return posts;
    }

    public List<Post> getAllPosts(){
        if (posts.isEmpty()){
            postSimulate();
        }
        return posts;
    }
//    public Post createPost(){
//        Post post = new Post(new User(
//                "demo000",
//                "demoName",
//                "demoSurname",
//                LocalDate.of(1985, 7,20),
//                "demo0000@gmail.com"
//        ), "postTitle", "ostBody");
//        return post;
//    }

//    public Post createPost(long authorId, String title, String body){
//        User user = userService.getUserById(authorId);
//        Post post = new Post(user, title, body);
//        return post;
//    }

    public Post createPost(long authorId, CreatePostDTO createPostDTO){
        User user = userService.getUserById(authorId);
        Post post = new Post(user, createPostDTO.getTitle(), createPostDTO.getMessage());
        return post;
    }

    public Post addComment(long postId, CreateCommentDTO createCommentDTO){
        Post commentToPost = getPostById(postId);
        Comment newComment = commentService.createComment(createCommentDTO);
        commentToPost.getComments().add(newComment);

        return commentToPost;
    }

    public Post deletePost(long postId){
        Post deletePost = getPostById(postId);
        return deletePost;
    }

    public Post editPost(long postId, long authorId, String newTitle, String newMessage){
        User user = userService.getUserById(authorId);
        Post post = getPostById(postId);
        if (post.getAuthor().getId().equals(user.getId())){
            post.setTitle(newTitle);
            post.setBody(newMessage);
            return post;
        } else {
            throw new IllegalArgumentException("This user cant edit not his post");
        }

    }

    public Post deleteCommentsFromMyPost(long postId, long authorId, long commentsId){
        User user = userService.getUserById(authorId);
        Post post = getPostById(postId);
        if (post.getAuthor().getId().equals(user.getId())){
            post.getComments().remove(commentsId);
            return post;
        } else {
            throw new IllegalArgumentException("This user cant delete not his post comments");
        }
    }

    public Post getPostById(long id){
        Post postById =
                posts.stream()
                        .filter(post -> post.getId().equals(id))
                        .findFirst().orElseThrow(()->{throw new NoSuchElementException(String.format("Post by id: {%s} not found", id));
                        });
        return postById;
    }



}

