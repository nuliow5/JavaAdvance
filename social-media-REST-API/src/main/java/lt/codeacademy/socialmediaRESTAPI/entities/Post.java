package lt.codeacademy.socialmediaRESTAPI.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Post {
    private Long id;
    private User author;
    private String title;
    private String body;
    private List<Comment> comments = new ArrayList<>();
    private LocalDate createdAt;
    private static Long idIncrementor = 1L;

    public Post(User created, String title, String body) {
        this.id = idIncrementor;
        this.author = created;
        this.title = title;
        this.body = body;
        this.createdAt = LocalDate.now();
        idIncrementor++;
    }
}
