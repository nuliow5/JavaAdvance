package lt.codeacademy.springdataexample.contolers;

import lt.codeacademy.springdataexample.converters.AnswerConverter;
import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.dto.CreateUpdateAnswerDTO;
import lt.codeacademy.springdataexample.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;



@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<AnswerDTO> getAnswer(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answerService.getAnswerById(id));
    }

    @GetMapping
    public List<AnswerDTO> getAllAnswers(){
        return AnswerConverter.convertAnswersToDto(this.answerService.getAllAnswers());
    }

    @PostMapping
    public ResponseEntity<AnswerDTO> addAnswer(@RequestBody CreateUpdateAnswerDTO answerDTO){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.answerService.addAnswer(answerDTO));
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Quest by ID: %s not found", answerDTO.getQuestionId()));
        }

    }

    @PutMapping
    public ResponseEntity<AnswerDTO> updateAnswer (@RequestBody CreateUpdateAnswerDTO answerDTO){
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.answerService.updateAnswer(answerDTO));
    }

//    @PutMapping
//    @RequestMapping("/{id}")
//    public ResponseEntity<AnswerDTO> updateAnswerById (@PathVariable long id, @RequestBody AnswerDTO answerDTO){
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(this.answerService.updateAnswerById(id, answerDTO));
//        } catch (NoSuchElementException e){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    String.format("Quest by ID: %s not found", answerDTO.getQuestionId()));
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable long id){
        this.answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }






}
