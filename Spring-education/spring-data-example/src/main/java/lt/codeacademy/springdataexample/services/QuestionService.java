package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.QuestionConverter;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.Question;
import lt.codeacademy.springdataexample.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class QuestionService {
    private ExamService examService;
    private QuestionRepository questionRepository;

    public QuestionDTO addQuestionToExam(QuestionDTO questionDTO) {
//        Exam examById = this.examService.getExamById(examId);
        Question question = QuestionConverter.convertQuestionToDTO(questionDTO);
//        question.setExam(examById);
        this.questionRepository.saveAndFlush(question);
        return questionDTO;
    }
}
