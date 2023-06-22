package lt.codeacademy.springdataexample.converters;

import lt.codeacademy.springdataexample.dto.AnswerDTO;
import lt.codeacademy.springdataexample.entities.Answer;
import lt.codeacademy.springdataexample.entities.Question;

import java.util.ArrayList;
import java.util.List;

public abstract class AnswerConverter {

    public static AnswerDTO convertAnswerToAnswerDTO(Answer answer){
        AnswerDTO answerDTO = null;
        if (answer != null){
            answerDTO = new AnswerDTO();
            answerDTO.setId(answer.getId());
            answerDTO.setText(answer.getText());
            answerDTO.setCorrect(answer.isCorrect());

        }

        return answerDTO;
    }

    public static Answer convertAnswerDTOToAnswer(AnswerDTO answerDTO){
        Answer answer = null;
        if (answerDTO != null){
            answer = new Answer();
            answer.setId(answerDTO.getId());
            answer.setText(answerDTO.getText());
            answer.setCorrect(answerDTO.isCorrect());

            if (answerDTO.getQuestionId() != null){
                Question question = new Question();
                question.setId(answer.getId());
            }
        }

        return answer;
    }

    public static List<AnswerDTO> convertAnswersToDTO(List<Answer> answers){
        List<AnswerDTO> answerDTOList = null;
        if (answers != null && !answerDTOList.isEmpty()){
            answerDTOList = new ArrayList<>();
            for (Answer a : answers){
                answerDTOList.add(AnswerConverter.convertAnswerToAnswerDTO(a));
            }
        }

        return answerDTOList;
    }
}
