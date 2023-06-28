package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    @Query(value = "SELECT id from Exam WHERE title =: name")
    Long findByName(String name);

}
