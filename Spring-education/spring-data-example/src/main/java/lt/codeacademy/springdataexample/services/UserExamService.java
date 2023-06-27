package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.UserExamConverter;
import lt.codeacademy.springdataexample.dto.UserExamDto;
import lt.codeacademy.springdataexample.entities.UserExam;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserExamService {
    private UserExamRepository userExamRepository;

    public List<UserExamDto> getAllUserExamDto(){
        List<UserExamDto> userExamDtoList = UserExamConverter.convertUserExamsListToDtoList(this.userExamRepository.findAll());
        return userExamDtoList;
    }

    public UserExamDto addUserExam(UserExamDto userExamDto){
        UserExam userExam = UserExamConverter.convertUserExamDtoToUserExam(userExamDto);
        this.userExamRepository.save(userExam);
        return  userExamDto;
    }


}
