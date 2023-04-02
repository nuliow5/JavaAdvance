package eu.codeacademy.firstLesson.taskStream;

import eu.codeacademy.firstLesson.task.Gender;
import eu.codeacademy.firstLesson.task.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //panaudoti stream atrenkant zodzius is stringu saraso, kurie prasideda raidemis 'A' arba 'S'

        ArrayList<String> myArray = new ArrayList<>(Arrays.asList("Zalgiris", "Saule", "Alus", "Sestadienis", "Pienas", "Duona"));
        ArrayList<String> myArray2 = new ArrayList<>(Arrays.asList("123", "123", "1234", "4567"));

        List<String> returnWords =
                myArray.stream()
                        .filter((word) -> word.charAt(0) == 'A' || word.charAt(0) == 'S')
                        .collect(Collectors.toList());


        System.out.println(returnWords);

        //rasti kiek sarase yra zodziu, kuriu raidziu skaicius yra nelyginis

        Integer returnCountOfWord =
                (int) myArray2.stream()
                        .filter((word) -> word.length() % 2 != 0)
                        .count();

        System.out.println(returnCountOfWord);

        //task
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");


        //1. Surasti, kiek yra tusciu elementu
        Long countEmpty =
                strList.stream()
                        .filter((word) -> word.length() == 0)
                        .count();

        System.out.println("count empty = " + countEmpty);

        //2. Surasti, kiek yra elementu, kuriu ilgis daugiau uz 3
        Long countyLength =
                strList.stream()
                        .filter((word) -> word.length() > 3)
                        .count();

        System.out.println("countyLength = " + countyLength);

        //4. Pasalinti visus tuscius elementus is saraso
        List<String> returnNotEmptyElements =
                strList.stream()
                        .filter((word) -> word.length() != 0)
                        .collect(Collectors.toList());

        System.out.println("returnNotEmptyElements = " + returnNotEmptyElements);

        //5. atrinkti tik tuos elementus, kuriu ilgis daugiau uz 2
        List<String> returnNotElementsLengthBiggestThatTwo =
                strList.stream()
                        .filter((word) -> word.length() > 2)
                        .collect(Collectors.toList());

        System.out.println("returnNotElementsLengthBiggestThatTwo = " + returnNotElementsLengthBiggestThatTwo);

        //6. paversti visus elementus i didziasias raides
        List<String> toUpperCase =
                strList.stream()
                        .map((word) -> word.toUpperCase())
                        .collect(Collectors.toList());
        System.out.println("toUpperCase = " + toUpperCase);


        //7. suskaiciuoti, kiek yra unikaliu elementu sarase
        Long countUnic =
                strList.stream()
                        .distinct()
                        .count();

        System.out.println("countUnic =" + countUnic);


        //8. Patikrinti, ar yra bent vienas elementas sarase, kurio ilgis yr 4 simboliai

        Boolean doesAnyOneElementHaveLengthFour =
                strList.stream()
                        .anyMatch((word) -> word.length() == 4);

        System.out.println("doesAnyOneElementHaveLengthFour = " + doesAnyOneElementHaveLengthFour);

        //9. Surusiuoti sarasa eiles tvarka
        List<String> sortedList =
                strList.stream()
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println("sortedList = " + sortedList);

        //10. Surusiuoti sarasa atvirksciai
        List<String> sortedListReverse =
                strList.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

        System.out.println("sortedList = " + sortedListReverse);

        //panaudojant map surinkti visu studentu kursus i sveiku skaiciu masyva ir isspausdinti

        List<Student> studentList = new ArrayList<>(Arrays.asList(
                new Student("Vadimas", "Bbbb", 3, Gender.MALE, FavoriteSubjec.MATH),
                new Student("Loreta", "Dddd", 15, Gender.FEMALE, FavoriteSubjec.MATH)
        ));

        List<Integer> courses = studentList.stream()
                .map(student -> student.getCourse())
                .collect(Collectors.toList());

        //With Maps
        Map<Gender, String> maps =
                studentList.stream()
                        .collect(Collectors.toMap(Student::getGender, Student::getName));
        System.out.println("map = " + maps);

//        Map<Gender, List<Student>> studentsByGender =
//                studentList.stream()
//                        .collect(Collectors.toMap(Student::getGender, );

        //Studentu rusiavimas
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::getCourse))
                .forEach(student1 -> System.out.println(student1.getName() + " " + student1.getCourse()));

        //Studentu rusiavimas atvirksciai
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::getCourse).reversed())
                .forEach(student1 -> System.out.println(student1.getName() + " " + student1.getCourse()));

        studentList
                .stream()
                .filter(stud -> stud.getCourse() == 2)
                .count();


    }
}
