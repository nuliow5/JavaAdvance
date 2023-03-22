package eu.codeacademy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Student {
    private String name;
    private String surname;
    private int age;
    private String course;
}
