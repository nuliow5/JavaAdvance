package lt.codeacademy.springdataexample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user_exam")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;

    private Double score;

    @ManyToMany
    @JoinTable(
            name = "user_exams_answers",
            joinColumns = @JoinColumn(name = "user_exam_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id")
    )
    private List<Answer> answers;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "update_at")
    private LocalDateTime updateAt;

    @PrePersist
    void persist() {
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    void update() {
        this.updateAt = LocalDateTime.now();
    }


}
