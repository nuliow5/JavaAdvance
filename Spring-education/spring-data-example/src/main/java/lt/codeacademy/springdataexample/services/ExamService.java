package lt.codeacademy.springdataexample.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.enumes.DifficultyLevel;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


//@AllArgsConstructor
@Service
@RequiredArgsConstructor
@Slf4j //loggeris
public class ExamService {
    @Value("${ca.test.value}")
    String caTestValue;

    @Autowired
    private ExamRepository examRepository;

    private final MessageSource messageSource;


    public ExamDTO addExam(ExamDTO examDTO) {
        Exam newExam = ExamConverter.convertExamDTOToExam(examDTO);
        this.examRepository.saveAndFlush(newExam);
        return examDTO;
    }


    public ExamDTO getExamById(Long examId) {
        ExamDTO examDTO = ExamConverter.convertExamToExamDTO(this.examRepository.findById(examId).get());



        return examDTO;


    }

//    public Exam getExamById(Long examId) {
//        return this.examRepository.findById(examId).get();
//    }

    public List<ExamDTO> getAllExams(DifficultyLevel difficultyLevel, Pageable pageable) {
        Page<Exam> examPage;
        if (difficultyLevel != null) {
            examPage = this.examRepository.findAllByDifficultyLevel(difficultyLevel, pageable);
        } else {
            examPage = this.examRepository.findAll(pageable);
        }
        //test
        System.out.println(caTestValue);
        log.error(messageSource.getMessage("obj.not.fount", null, LocaleContextHolder.getLocale()));
        //end test
        return ExamConverter.convertExamsToExamDTO(examPage);
    }

    public List<ExamDTO> findByDifficultyLevel(DifficultyLevel difficultyLevel, Pageable pageable) {
        Page<Exam> examPage;
        examPage = this.examRepository.findAllByDifficultyLevel(difficultyLevel, pageable);

        return ExamConverter.convertExamsToExamDTO(examPage);
    }


    public ExamDTO updateExam(ExamDTO examDTO) {
        Exam exam = examRepository.findById(examDTO.getId()).orElseThrow();
        exam.setTitle(examDTO.getTitle());
        examRepository.save(exam);
        return ExamConverter.convertExamToExamDTO(exam);
    }

    public void deleteExam(Long id) {
        if (examRepository.findById(id).isPresent()) {
            examRepository.deleteById(id);
        }


    }

}
