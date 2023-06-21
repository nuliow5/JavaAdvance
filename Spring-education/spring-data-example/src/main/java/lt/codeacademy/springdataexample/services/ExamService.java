package lt.codeacademy.springdataexample.services;

import lombok.AllArgsConstructor;
import lt.codeacademy.springdataexample.converters.ExamConverter;
import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;
import lt.codeacademy.springdataexample.repositories.ExamRepository;
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

    public Exam getExamById(Long examId) {
        return this.examRepository.findById(examId).get();
    }

    public List<ExamDTO> getAllExams() {
        List<Exam> examList = this.examRepository.findAll();
        return ExamConverter.convertExamsToExamDTO(examList);
    }

}
