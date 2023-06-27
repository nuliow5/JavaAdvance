package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.UserExamDto;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.User;
import lt.codeacademy.springdataexample.entities.UserExam;

import java.util.ArrayList;
import java.util.List;

public class UserExamConverter {



    public static UserExamDto convertUserExamToUserExamDto(UserExam userExam) {
        UserExamDto userExamDto = null;
        if (userExam != null) {
            userExamDto = new UserExamDto();
            userExamDto.setId(userExam.getId());
            userExamDto.setScore(userExam.getScore());

            if(userExam.getExam() != null) {
                userExamDto.setExamId(userExam.getExam().getId());
            }

            if(userExam.getUser() != null) {
                userExamDto.setUserId(userExam.getUser().getId());
            }
        }
        return userExamDto;
    }

    public static UserExam convertUserExamDTOToUserExam(UserExamDto userExamDto){
        UserExam userExams = null;
        if (userExamDto != null){
            userExams = new UserExam();
            userExams.setId(userExamDto.getId());
            if (userExamDto.getUserId() != null){
                User user = new User();
                user.setId(userExamDto.getId());
                userExams.setUser(user);
            }
            if (userExamDto.getExamId() != null){
                Exam exam = new Exam();
                exam.setId(userExamDto.getExamId());
                userExams.setExam(exam);
            }
            userExams.setScore(userExamDto.getScore());
        }
        return userExams;
    }

    public static UserExam convertUserExamDtoToUserExam(UserExamDto userExamDTO){
        UserExam userExam = null;
        if(userExamDTO != null){
            userExam = new UserExam();
            userExam.setId(userExamDTO.getId());
            userExam.setScore(userExamDTO.getScore());
            if(userExamDTO.getExamId() != null){
                Exam exam = new Exam();
                exam.setId(userExamDTO.getExamId());
                userExam.setExam(exam);
            }
            if(userExamDTO.getUserId() != null){
                User user = new User();
                user.setId(userExamDTO.getUserId());
                userExam.setUser(user);
            }
        }
        return userExam;
    }

//    public static UserExam convertUserExamDtoToUserExam(UserExamDto userExamDto){
//        UserExam userExam = null;
//        if (userExamDto != null){
//            userExam = new UserExam();
//            userExam.setId(userExamDto.getId());
//            userExam.setUser();
//        }
//    }

    public static List<UserExamDto> convertUserExamsListToDtoList(List<UserExam> userExams) {
        List<UserExamDto> userExamDtoList = null;
        if (userExams != null && !userExams.isEmpty()) {
            userExamDtoList = new ArrayList<>();
            for (UserExam ua : userExams) {
                userExamDtoList.add(convertUserExamToUserExamDto(ua));
            }
        }
        return userExamDtoList;
    }

}
