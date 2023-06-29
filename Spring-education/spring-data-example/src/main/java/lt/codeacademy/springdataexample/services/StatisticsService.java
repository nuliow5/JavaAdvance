package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;
import lt.codeacademy.springdataexample.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StatisticsService {

    private UserExamRepository userExamRepository;

    private ExamRepository examRepository;



//    public List<StatisticsDTO> countHowManyTimeExamBySolved(String examName){
//        long examId = this.examRepository.findByName(examName);
//
//        return userExamRepository.getAllStatistic(examId);
//    }

    public List<StatisticsDTO> getAllStatistics (){
        List<StatisticsDTO> statisticsDTOList = new ArrayList<>();
        List<Exam> examList = examRepository.findAll();
        for (int i = 0; i < examList.size(); i++) {
            statisticsDTOList.add(getStatisticDTOFromExam(examList.get(i)));
        }
        return statisticsDTOList;

    }

    public StatisticsDTO getStatisticDTOFromExam(Exam exam){
        return new StatisticsDTO(
                exam.getTitle(),
                userExamRepository.averageScoreByExamId(exam.getId()),
                userExamRepository.countSolvedExamById(exam.getId())
                );
    }

    public StatisticsDTO getStatisticDTOByExamTitle(String examTitle){
        Exam exam = examRepository.findExamByTitle(examTitle);
        return getStatisticDTOFromExam(exam);

    }


}
