package lt.codeacademy.springdataexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoldExamDto {
    private Long userId;
    private Long examId;
    private List<Long> answerIds;
    private Double score;
    private List<Long> correctAnswerIds;
}
