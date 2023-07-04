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
            examDTO.setDifficultyLevel(exam.getDifficultyLevel());
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
            exam.setDifficultyLevel(examDTO.getDifficultyLevel());
        }

        return exam;
    }

    public static List<ExamDTO> convertExamsToExamDTO(Iterable<Exam> examList) {
        List<ExamDTO> examDTOList = null;
        if (examList != null ) {
            examDTOList = new ArrayList<>();
            for (Exam e : examList) {
                examDTOList.add(ExamConverter.convertExamToExamDTO(e));
            }
        }
        return examDTOList;
    }
}
