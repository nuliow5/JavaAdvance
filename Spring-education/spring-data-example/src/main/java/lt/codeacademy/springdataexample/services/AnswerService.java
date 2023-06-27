package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.AnswerConverter;
import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.repositories.AnswerRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;


@Service
@AllArgsConstructor
public class AnswerService {
    private AnswerRepository answerRepository;

    private QuestionService questionService;

    public AnswerDTO getAnswerById(Long id) {
        AnswerDTO answerDTO = AnswerConverter.convertAnswerToAnswerDto(this.answerRepository.findById(id).get());
        return answerDTO;
    }

    public List<Answer> getAllAnswers() {
        List<Answer> answers = this.answerRepository.findAll();
        return answers;
    }

    public AnswerDTO addAnswer(AnswerDTO answerDTO) throws NoSuchElementException {
        if (!doesAnswerIdEqualQuestId(answerDTO)) {
            throw new NoSuchElementException();
        }

        Answer answer = AnswerConverter.convertAnswerDtoToAnswer(answerDTO);
        this.answerRepository.save(answer);
        return answerDTO;

    }

    public boolean doesAnswerIdEqualQuestId(AnswerDTO answerDTO) {
        List<QuestionDTO> questions = questionService.getAllQuestions();

        for (int i = 0; i < questions.size(); i++) {
            if (answerDTO.getQuestionId().equals(questions.get(i).getId())) {
                return true;
            }
        }

        return false;
    }

    public AnswerDTO updateAnswer (AnswerDTO answerDTO){
        Answer updateAnswer = AnswerConverter.convertAnswerDtoToAnswer(answerDTO);
        updateAnswer.setCreatedAt(answerRepository.findById(answerDTO.getId()).get().getCreatedAt());

        answerRepository.save(updateAnswer);
        return answerDTO;


    }


    public void deleteAnswer(long id){
        if (answerRepository.findById(id).isPresent()){
            answerRepository.deleteById(id);
        }
    }


}
