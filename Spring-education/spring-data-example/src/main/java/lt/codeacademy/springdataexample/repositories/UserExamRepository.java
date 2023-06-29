package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.entities.UserExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserExamRepository extends JpaRepository<UserExam, Long> {
    @Query(value = "SELECT a FROM UserExam  a WHERE a.exam.id =:examId")
    List<StatisticsDTO> getAllStatistic(Long examId);

    @Query(value = "SELECT avg(score) from UserExam WHERE exam.id =:examId")
    Double averageScoreByExamId(Long examId);

    //    @Query(value = "SELECT count(*) from user_exam WHERE exam_id =?1", nativeQuery = true)
    @Query(value = "SELECT count(*) from UserExam WHERE exam.id = :examId")
    Integer countSolvedExamById(@Param("examId") Long examId);
}
