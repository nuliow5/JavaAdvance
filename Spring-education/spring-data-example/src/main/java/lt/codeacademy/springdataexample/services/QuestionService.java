package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.QuestionConverter;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
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

    public QuestionDTO updateQuestion(QuestionDTO questionDTO){
        Question question = questionRepository.findById(questionDTO.getId()).orElseThrow();
        question.setText(questionDTO.getText());

        if (!question.getExam().getId().equals(question.getExam().getId())){
            question.setExam(question.getExam());
        }

        questionRepository.save(question);
        return QuestionConverter.convertQuestionToDTO(question);
    }


    public void deleteQuestionById(Long id) {
        if (questionRepository.findById(id).isPresent()){
            questionRepository.deleteById(id);
        }

    }
}
