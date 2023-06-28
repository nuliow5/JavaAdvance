package lt.codeacademy.springdataexample.services;

import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import lt.codeacademy.springdataexample.repositories.StatisticsRepository;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
                userExamRepository.averageScoreByExamId(exam.getId()),                   //Query averageScore
                userExamRepository.countExcemByHowManyTimeBySolved(exam.getId())         //!uery submissionCount
                );
    }


}
