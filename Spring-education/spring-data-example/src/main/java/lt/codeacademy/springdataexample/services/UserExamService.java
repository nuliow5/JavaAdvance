package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.UserExamConverter;
import lt.codeacademy.springdataexample.dto.HoldExamDto;
import lt.codeacademy.springdataexample.dto.UserExamDto;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.User;
import lt.codeacademy.springdataexample.entities.UserExam;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserExamService {
    private UserExamRepository userExamRepository;

    private AnswerService answerService;

//    public List<UserExamDto> getAllUserExamDto(){
//        List<UserExamDto> userExamDtoList = UserExamConverter.convertUserExamsListToDtoList(this.userExamRepository.findAll());
//        return userExamDtoList;
//    }

//    public UserExamDto addUserExam(UserExamDto userExamDto){
//        UserExam userExam = UserExamConverter.convertUserExamDtoToUserExam(userExamDto);
//        this.userExamRepository.save(userExam);
//        return  userExamDto;
//    }

    public HoldExamDto holdExam(HoldExamDto holdExamDto) {

        List<Long> correctAnswerIds = answerService.getAllAnswersByIds(holdExamDto.getAnswerIds())
                .stream()
                .filter(answer -> answer.getIsCorrect())
                .map(answer -> answer.getId())
                .collect(Collectors.toList());

        UserExam userExam = new UserExam();
        userExam.setScore(Double.valueOf(correctAnswerIds.size()));
        userExam.setUser(new User(holdExamDto.getUserId()));
        userExam.setExam(new Exam(holdExamDto.getExamId()));
        List<Answer> answerList = new ArrayList<>();
        holdExamDto.getAnswerIds().forEach(answerId -> {
            answerList.add(new Answer(answerId));
        });
        userExam.setAnswers(answerList);
        userExamRepository.save(userExam);
        holdExamDto.setScore(userExam.getScore());
        holdExamDto.setCorrectAnswerIds(correctAnswerIds);

        return holdExamDto;

    }

}
