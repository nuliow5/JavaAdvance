package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    @Query(value = "SELECT a FROM Exam a WHERE a.title =:title")
    Exam findExamByTitle(String title);


}
