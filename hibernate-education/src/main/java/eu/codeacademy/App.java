package eu.codeacademy;

import eu.codeacademy.helper.CreateBase;
import eu.codeacademy.model.Student;
import eu.codeacademy.service.StudentService;


public class App {

    public static void main(String[] args) {
        CreateBase.startBuilder();
        StudentService studServ = new StudentService();

        Student newStudent = createStudentLikeObj("Eva", "Gerasimova", 18, 2);

        studServ.createStudent("Vadimas", "Gerasimovas", 37, 2);
        studServ.updateStudentById(1L, newStudent);
    }

    public static Student createStudentLikeObj(String name, String surname, int age, int course){
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);
        student.setCourse(course);

        return student;
    }
}
