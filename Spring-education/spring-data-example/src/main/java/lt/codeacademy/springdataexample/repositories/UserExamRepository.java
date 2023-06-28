package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.dto.StatisticsDTO;
import lt.codeacademy.springdataexample.entities.UserExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserExamRepository extends JpaRepository<UserExam, Long> {
    @Query(value = "SELECT a FROM UserExam  a WHERE a.exam.id =:examId")
    List<StatisticsDTO> getAllStatistic(Long examId);
}
