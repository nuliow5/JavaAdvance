package lt.codeacademy.socialmediaRESTAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreatePostDTO {
    private Long authorId;
    private String title;
    private String message;

}
