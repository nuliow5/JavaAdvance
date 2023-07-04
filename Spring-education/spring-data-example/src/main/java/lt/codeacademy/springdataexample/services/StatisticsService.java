package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.UserExam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import lt.codeacademy.springdataexample.repositories.UserExamRepository;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsService {
    private UserExamRepository userExamRepository;
    private ExamRepository examRepository;

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

//    public StatisticsDTO getStatisticDTOByExamTitle(String examTitle){
//        Exam exam = examRepository.findExamByTitle(examTitle);
//        return getStatisticDTOFromExam(exam);
//    }



//    public Pair<Double, Integer> examScoreAverageAndCountExamSolvedTime(Exam exam){
//        MutablePair<Double, Integer> ans;
//        Double sum = 0d;
//        Integer count = 0;
//        Double result = 0d;
//        for (int i = 0; i < userExams.size(); i++) {
//            if (userExams.get(i).getExam().equals(exam)){
//                sum += userExams.get(i).getScore();
//                count++;
//            }
//        }
//
//        if (count != 0){
//            result = sum / count;
//        }
//
//
//        return ans = new MutablePair<>(result, count);
//    }


}
