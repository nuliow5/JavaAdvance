package lt.codeacademy.springdataexample.contolers;

import lt.codeacademy.springdataexample.entities.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams")
public class ExamService {
    @Autowired
    private ExamService examService;

    @PostMapping
    public void addExam(@RequestBody Exam exam){
        this.examService.addExam(exam);
    }

}
