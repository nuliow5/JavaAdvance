package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.ExamDTO;
import lt.codeacademy.springdataexample.entities.Exam;

import java.util.ArrayList;
import java.util.List;

public abstract class ExamConverter {

    public static ExamDTO convertExamToExamDTO(Exam exam) {
        ExamDTO examDTO = null;
        if (exam != null) {
            examDTO = new ExamDTO();
            examDTO.setId(exam.getId());
            examDTO.setTitle(exam.getTitle());
            examDTO.setQuestions(QuestionConverter.convertQuestionsToDTO(exam.getQuestions()));
        }
        return examDTO;
    }

    public static Exam convertExamDTOToExam(ExamDTO examDTO){
        Exam exam = null;
        if (examDTO != null){
            exam = new Exam();
            exam.setId(exam.getId());
            exam.setTitle(examDTO.getTitle());
        }

        return exam;
    }

    public static List<ExamDTO> convertExamsToExamDTO(List<Exam> examList) {
        List<ExamDTO> examDTOList = null;
        if (examList != null && !examList.isEmpty()) {
            examDTOList = new ArrayList<>();
            for (Exam e : examList) {
                examDTOList.add(ExamConverter.convertExamToExamDTO(e));
            }
        }
        return examDTOList;
    }
}
