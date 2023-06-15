package lt.codeacademy.socialmediaRESTAPI.services;

import lt.codeacademy.socialmediaRESTAPI.dto.PostDTO;
import lt.codeacademy.socialmediaRESTAPI.dto.UserDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.Post;

import lt.codeacademy.socialmediaRESTAPI.entities.User;
import lt.codeacademy.socialmediaRESTAPI.mappers.PostDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {

    @Autowired
    PostDTOMapper postDTOMapper;
    private UserService userService;
    private CommentService commentService;
    private List<Post> posts = new ArrayList<>();

    UserDTO userDTO;

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

    public PostDTO getPostDTOById(long id){
        Post postById =
                this.posts.stream()
                        .filter(post -> post.getId().equals(id))
                        .findFirst().orElseThrow(()->{
            throw new NoSuchElementException(String.format("User by id: {%s} not found", id));
        });

        return postDTOMapper.apply(postById);
    }

    public PostDTO createPost(PostDTO postDTO){
        posts.add(new Post(
                userService.getUserById(postDTO.authorId()),
                postDTO.title(),
                postDTO.message()
        ));
        return postDTO;
    }

    public Post getPostById(long id){
        Post postById =
                this.posts.stream()
                        .filter(post -> post.getId().equals(id))
                        .findFirst().orElseThrow(()->{
                            throw new NoSuchElementException(String.format("User by id: {%s} not found", id));
                        });
        return postById;
    }

    public PostDTO updatePostDTOById(long id, PostDTO postDTO){
        Post updatingPost = getPostById(id);
        updatingPost.setTitle(postDTO.title());
        updatingPost.setMessage(postDTO.message());

        return postDTO;
    }


    public Post deletePost(long postId){
        Post deletePost = getPostById(postId);
        return deletePost;
    }
    //??? for test
    public Post editPost(long postId, long authorId, String newTitle, String newMessage){
        UserDTO userDTO = userService.getUserDTOById(authorId);
        Post post = getPostById(postId);
        if (post.getAuthor().getId().equals(userDTO.id())){
            post.setTitle(newTitle);
            post.setMessage(newMessage);
            return post;
        } else {
            throw new IllegalArgumentException("This user cant edit not his post");
        }
    }

    public Post deleteCommentsFromMyPost(long postId, long authorId, long commentsId){
        UserDTO userDTO = userService.getUserDTOById(authorId);
        Post post = getPostById(postId);
        if (post.getAuthor().getId().equals(userDTO.id())){
            post.getComments().remove(commentsId);
            return post;
        } else {
            throw new IllegalArgumentException("This user cant delete not his post comments");
        }
    }






}

