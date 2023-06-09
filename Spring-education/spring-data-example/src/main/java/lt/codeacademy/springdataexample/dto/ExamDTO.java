package lt.codeacademy.springdataexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.springdataexample.enumes.DifficultyLevel;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamDTO {
    private Long id;
    private String title;
    private List<QuestionDTO> questions;
    private DifficultyLevel difficultyLevel;
}
