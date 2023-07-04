package lt.codeacademy.springdataexample.contolers;


import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.enumes.DifficultyLevel;
import lt.codeacademy.springdataexample.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


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
    public ResponseEntity<List<ExamDTO>> getAllExams(@RequestParam(name = "difficultyLevel", required = false) DifficultyLevel difficultyLevel,
                                                     @PageableDefault Pageable pageable) {
        return ResponseEntity.ok(this.examService.getAllExams(difficultyLevel, pageable));
    }

//    @GetMapping
//    @RequestMapping("{/difficultyLevel}")
//    public ResponseEntity<List<ExamDTO>> getExamsByDifficulty(@PathVariable String difficultyLevel,
//                                                              @PageableDefault Pageable pageable){
//        return ResponseEntity.ok(this.examService.findByDifficultyLevel(pageable, difficultyLevel));
//    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<ExamDTO> getExamById(@PathVariable Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(examService.getExamById(id));
    }

    @PutMapping
    public ResponseEntity<ExamDTO> updateExam(@RequestBody ExamDTO examDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.examService.updateExam(examDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEsam(@PathVariable Long id) {
        this.examService.deleteExam(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
