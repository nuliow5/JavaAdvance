package lt.codeacademy.socialmediaRESTAPI.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Comment {
    private Long id;
    private User author;
    private String body;
    private LocalDate createdAt;
    private LocalDate editAt;
    private static Long idIncrementor = 1L;

    public Comment(User user, String commentBody) {
        this.id = idIncrementor;
        this.author = user;
        this.body = commentBody;
        this.createdAt = LocalDate.now();
        editAt = LocalDate.now();
    }
}
