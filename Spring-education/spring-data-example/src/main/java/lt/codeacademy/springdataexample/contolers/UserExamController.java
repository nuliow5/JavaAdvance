package lt.codeacademy.springdataexample.contolers;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.dto.HoldExamDto;
import lt.codeacademy.springdataexample.dto.UserExamDto;
import lt.codeacademy.springdataexample.entities.UserExam;
import lt.codeacademy.springdataexample.services.UserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserExams")
public class UserExamController {

    @Autowired
    private UserExamService userExamService;

//    @GetMapping
//    public List<UserExamDto> getAllUserExamDto(){
//        return this.userExamService.getAllUserExamDto();
//    }
//
//    @PostMapping
//    public ResponseEntity<UserExamDto> addUserExam (@RequestBody UserExamDto userExamDto){
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(this.userExamService.addUserExam(userExamDto));
//    }

    @PostMapping
    public ResponseEntity<HoldExamDto> holdExam(@RequestBody HoldExamDto holdExamDto) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(userExamService.holdExam(holdExamDto));
    }




}
