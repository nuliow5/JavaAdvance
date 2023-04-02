package eu.codeacademy.firstLesson.taskStream;

import eu.codeacademy.firstLesson.task.Gender;
import eu.codeacademy.firstLesson.task.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskWithObject {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>(Arrays.asList(
                new Student("Gytis", "Gyskauskas", 1, Gender.MALE, FavoriteSubjec.MATH),
                new Student("Ona", "Onaitiene", 1, Gender.FEMALE, FavoriteSubjec.IT),
                new Student("Nabtas", "Nabtilijus", 2, Gender.MALE, FavoriteSubjec.IT),
                new Student("Erikas", "Derikas", 2, Gender.MALE, FavoriteSubjec.MATH),
                new Student("Julia", "Julcike", 4, Gender.FEMALE, FavoriteSubjec.PHYSICS)
        ));

//        1. Patikrinti, ar klaseje yra bent vienas studentas vardu Tomas
        boolean doesWeHaveTomas = studentList
                .stream()
                .anyMatch(stud -> stud.getName().equals("Tomas"));
        System.out.println("doesWeHaveTomas = " + doesWeHaveTomas);

//        2. Suskaiciuoti, kiek klaseje yra studentu, kuriu megstamiausias dalykas yra IT
        int howManyStudentLikeIT = (int)
                studentList
                        .stream()
                        .filter(stud -> stud.getFavoriteSubjec().equals(FavoriteSubjec.IT))
                        .count();

        System.out.println("howManyStudentLikeIT = " + howManyStudentLikeIT);


//        3. Grazinti sarasa unikaliu studentu vardu (List<String>);
        List<String> unicNames =
                studentList.stream()
                        .map(stud -> stud.getName())
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("unicNames = " + unicNames);

//        4. Surusiuoti studentus pagal varda abeceles tvarka;
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(stud -> System.out.println(stud));

//        5. Atrinkti studentus, kuriu vidurkis yra didesnis uz 7 (vidurkiui skaiciu naudoti atskirai parasyta metoda Student klaseje);
        List<Student> studentListWhoHaveGradeBiggestThatSeven =
                studentList
                        .stream()
                        .filter(stud -> stud.averageGrade() > 7)
                        .collect(Collectors.toList());

        System.out.println("studentListWhoHaveGradeBiggestThatSeven = " + studentListWhoHaveGradeBiggestThatSeven);


    }
}
