package lt.codeacademy.restapiexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private Long id;
    private String name;
    private String lastName;
    private int age;


}
