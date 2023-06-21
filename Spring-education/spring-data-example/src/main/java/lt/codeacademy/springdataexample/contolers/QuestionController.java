package lt.codeacademy.springdataexample.contolers;

import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @PostMapping()
    public ResponseEntity<QuestionDTO> addExamQuestion(@RequestBody QuestionDTO questionDTO) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(questionService.addQuestionToExam(questionDTO));
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Exam by ID: %s not found", questionDTO.getExamId()));
        }
    }
}
