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

    public ExamDTO getExamById(Long examId) {
        ExamDTO examDTO = ExamConverter.convertExamToExamDTO(this.examRepository.findById(examId).get());
        return examDTO;
    }

    public List<ExamDTO> getAllExams() {
        List<Exam> examList = this.examRepository.findAll();
        return ExamConverter.convertExamsToExamDTO(examList);
    }

    public ExamDTO updateExamById(Long id, ExamDTO examDTO) {
        ExamDTO updatingExamDTO = getExamById(id);
        updatingExamDTO.setId(examDTO.getId());
        updatingExamDTO.setTitle(examDTO.getTitle());
        updatingExamDTO.setQuestions(examDTO.getQuestions());

        this.examRepository.saveAndFlush(ExamConverter.convertExamDTOToExam(updatingExamDTO));
        return examDTO;
    }

    public List<ExamDTO> deleteEsamById(Long id){
        List<Exam> examList = this.examRepository.findAll();
        examList.remove(id);
        return ExamConverter.convertExamsToExamDTO(examList);
    }

}
