package lt.codeacademy.springdataexample.contolers;

import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.dto.CreateUpdateAnswerDTO;
import lt.codeacademy.springdataexample.repositories.UserRepository;
import lt.codeacademy.springdataexample.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.NoSuchElementException;


@CrossOrigin
@RestController
@PreAuthorize("hasRole('TEACHER')")
@RequestMapping("/answers")
public class AnswerController {

    private static final Integer DEFAULT_PAGE_SIZE = 5;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<AnswerDTO> getAnswer(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(answerService.getAnswerById(id));
    }

    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAllAnswers(@RequestParam(name = "isCorrect", required = false) Boolean isCorrect,
                                         @PageableDefault Pageable pageable){


        return ResponseEntity.ok(this.answerService.getAllAnswers(isCorrect, pageable));
//        return AnswerConverter.convertAnswersToDto(this.answerService.getAllAnswers());
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
