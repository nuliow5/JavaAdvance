package lt.codeacademy.springdataexample.contolers;

import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Question;
import lt.codeacademy.springdataexample.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<QuestionDTO> getQuestions (){
        return this.questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDTO> getQuestionById(@PathVariable Long id) {
        return ResponseEntity.ok(questionService.getQuestionById(id));
    }

    @PostMapping()
    public ResponseEntity<QuestionDTO> addExamQuestion(@RequestBody QuestionDTO questionDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(questionService.addQuestionToExam(questionDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Exam by ID: %s not found", questionDTO.getExamId()));
        }
    }

    @PutMapping
    public ResponseEntity<QuestionDTO> updateQuestion(@RequestBody QuestionDTO questionDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questionService.updateQuestion(questionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionById(@PathVariable Long id){
        this.questionService.deleteQuestionById(id);
        return ResponseEntity
                .noContent().build();
    }

}
