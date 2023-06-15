package lt.codeacademy.socialmediaRESTAPI.mappers;

import lt.codeacademy.socialmediaRESTAPI.dto.PostDTO;
import lt.codeacademy.socialmediaRESTAPI.entities.Post;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostDTOMapper implements Function<Post, PostDTO> {


    @Override
    public PostDTO apply(Post post) {
        return new PostDTO(
                post.getId(),
                post.getAuthor().getId(),
                post.getTitle(),
                post.getMessage()
        );
    }
}
