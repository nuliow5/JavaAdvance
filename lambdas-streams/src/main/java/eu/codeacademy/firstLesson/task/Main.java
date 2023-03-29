package eu.codeacademy.firstLesson.task;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Vardenis", "Pavardenis", 3);

        Consumer<Student> printStudentName = (student1) -> System.out.println(student1.getName());
        printStudentName.accept(student);

        Supplier<Student> creteStudent = () -> new Student("AAA", "Bbbb", 1);
        creteStudent.get();

        Predicate<Student> doesStudentIn3Course = (student1) -> student1.getCourse() == 3;
        doesStudentIn3Course.test(student);



    }
}
