package eu.codeacademy.firstLesson.task;

import eu.codeacademy.firstLesson.taskStream.FavoriteSubjec;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;
import java.util.StringJoiner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String surname;
    private int course;
    private Gender gender;
    private FavoriteSubjec favoriteSubjec;

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("course=" + course)
                .add("gender=" + gender)
                .add("favoriteSubjec=" + favoriteSubjec)
                .toString();
    }

    public int averageGrade(){
        Random random = new Random(10);
        return random.nextInt(10)+1;
    }
}
