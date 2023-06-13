package lt.codeacademy.restapiexample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Lecture {
    private String title;
    private List<Student> attendants;
}
