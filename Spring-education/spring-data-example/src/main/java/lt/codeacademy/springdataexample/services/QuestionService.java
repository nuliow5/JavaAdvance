package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.QuestionConverter;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Question;
import lt.codeacademy.springdataexample.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService {
    private ExamService examService;
    private QuestionRepository questionRepository;

    public List<QuestionDTO> getAllQuestions(){
        List<Question> questions = this.questionRepository.findAll();
        return QuestionConverter.convertQuestionsToDTO(questions);
    }
    public QuestionDTO addQuestionToExam(QuestionDTO questionDTO) {
        Question question = QuestionConverter.convertQuestionDtoToQuestion(questionDTO);
        this.questionRepository.saveAndFlush(question);
        return QuestionConverter.convertQuestionToDTO(question);
    }

    //?
    public QuestionDTO updateQuestion(QuestionDTO questionDTO){
        Question question = questionRepository.findById(questionDTO.getId()).orElseThrow();
        question.setText(questionDTO.getText());

        if (!question.getExam().getId().equals(question.getExam().getId())){
            question.setExam(question.getExam());
        }

        questionRepository.save(question);
        return QuestionConverter.convertQuestionToDTO(question);
    }

    public QuestionDTO getQuestionById(Long id) {
        return QuestionConverter.convertQuestionToDTO(questionRepository.getReferenceById(id));
    }


    public void deleteQuestionById(Long id) {
        if (questionRepository.findById(id).isPresent()){
            questionRepository.deleteById(id);
        }

    }
}
