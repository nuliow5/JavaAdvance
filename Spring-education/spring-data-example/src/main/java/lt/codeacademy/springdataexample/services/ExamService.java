package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.enumes.DifficultyLevel;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ExamService {
    private ExamRepository examRepository;

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
