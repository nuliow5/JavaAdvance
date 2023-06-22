package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.AnswerConverter;
import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.repositories.AnswerRepository;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AnswerService {
    private AnswerRepository answerRepository;

    public AnswerDTO getAnswerById(Long id){
       AnswerDTO answerDTO = AnswerConverter.convertAnswerToAnswerDTO(this.answerRepository.findById(id).get());
        return answerDTO;
    }

    public List<Answer> getAllAnswers(){
        List<Answer> answers = this.answerRepository.findAll();
        return answers;
    }

    public AnswerDTO addAnswer(AnswerDTO answerDTO){
        Answer answer = AnswerConverter.convertAnswerDTOToAnswer(answerDTO);
        this.answerRepository.save(answer);
        return answerDTO;
    }





}
