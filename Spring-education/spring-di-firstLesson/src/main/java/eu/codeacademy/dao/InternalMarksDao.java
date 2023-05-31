package eu.codeacademy.dao;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class InternalMarksDao implements MarksDao{
    @Override
    public List<Integer> getMarks() {
        //praktiskai turetu kreiptis i db, istraukia azymius ir t.t.

        return List.of(10, 5, 7, 9, 3, 10, 8);
    }
}
