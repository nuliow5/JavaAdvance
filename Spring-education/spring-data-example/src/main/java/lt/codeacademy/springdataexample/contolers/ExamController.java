package lt.codeacademy.springdataexample.contolers;

import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.dto.QuestionDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.Question;
import lt.codeacademy.springdataexample.services.ExamService;
import lt.codeacademy.springdataexample.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<ExamDTO> addExam(@RequestBody ExamDTO examDTO) {
       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(this.examService.addExam(examDTO));

    }

    @GetMapping
    public List<ExamDTO> getAllExams() {
        return this.examService.getAllExams();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ExamConverter.convertExamToExamDTO(examService.getExamById(id)));
    }


}
