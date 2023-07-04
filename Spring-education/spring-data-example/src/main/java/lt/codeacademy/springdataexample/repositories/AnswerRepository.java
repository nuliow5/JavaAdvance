package lt.codeacademy.springdataexample.repositories;

import lt.codeacademy.springdataexample.entities.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Page<Answer> findByQuestion_TextStartsWithIgnoreCaseOrQuestion_TextStartsWithIgnoreCaseOrQuestion_TextStartsWithIgnoreCase(@NonNull String text, @Nullable String text1, @Nullable String text2, Pageable pageable);
//    @Query(value = "select * from answer where is_correct = :isCorrect; ", nativeQuery = true)
//    List<Answer> getAllAnswersByIsCorrect(Boolean isCorrect);
//
//    /*
//    ?1 - pirmas parametras, -> select * from answer where is_correct = ?1;
//    ?2 - antras pametras, bet nera gera praktika jos nauduoti
//    geriau naudoti param -> select * from answer where is_correct = :isCorrect
//    jeigu paduoti kintamojo pavadinimas i methoda nesutampa su queryje, galime apsirasyti su @Param();
//     */
//
//    @Query(value = "select * from Answer where is_correct = ?1; ")
//    List<Answer> getAllAnswersByIsCorrect2(Boolean isCorrect);

    Page<Answer> findAllByIsCorrect(Boolean isCorrect, Pageable pageable);

    Page<Answer> findAllByText(String text, Pageable pageable);



}
