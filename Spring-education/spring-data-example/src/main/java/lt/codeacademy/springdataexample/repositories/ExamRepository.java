package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.entities.User;
import lt.codeacademy.springdataexample.enumes.DifficultyLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExamRepository extends JpaRepository<Exam, Long> {
    @Query(value = "SELECT a FROM Exam a WHERE a.title =:title")
    Exam findExamByTitle(String title);

    Page<Exam> findAllByDifficultyLevel(DifficultyLevel difficultyLevel, Pageable pageable);


}
