package lt.codeacademy.springdataexample.services;

import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.dto.UserDto;
import lt.codeacademy.springdataexample.dto.UserExamDto;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.User;
import lt.codeacademy.springdataexample.entities.UserExam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultLogic {


    private UserExam userExam;

    private UserDto userDto;

    private ExamDTO examDTO;

    public void examResult(UserDto userDTO, ExamDTO examDTO){
        List<UserExamDto> exams = userDTO.getUserExams();
    }





}
