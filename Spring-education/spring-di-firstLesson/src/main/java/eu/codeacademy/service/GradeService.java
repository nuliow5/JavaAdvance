package eu.codeacademy.service;

import eu.codeacademy.dao.MarksDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GradeService {

    private final MarksDao marksDao;

    public GradeService( MarksDao marksDao) {
        this.marksDao = marksDao;
    }

    public Double averageGrade(){

        List<Integer> grades = marksDao.getMarks();
        Double sum = 0.0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }

        Double result = sum / grades.size();

        return result;
    }
}
