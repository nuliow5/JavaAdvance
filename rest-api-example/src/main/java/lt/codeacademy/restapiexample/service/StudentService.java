package lt.codeacademy.restapiexample.service;

import lt.codeacademy.restapiexample.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    public List<Student> simulate(){
        students.add(new Student(1L, "Antanas", "Antanaitis", 20 ));
        students.add(new Student(2L, "Petras", "Petraitis", 45 ));
        students.add(new Student(3L, "Jonas", "Jonaitis", 30 ));
        students.add(new Student(4L, "Ona", "Onutaite", 25 ));
        return students;
    }

    public List<Student> getAllStudents(){
        if (this.students.isEmpty()) {
            simulate();
        }

        return students;
    }

    public Student getStudentById(long id){
        Student studentToGet =
                this.students.stream()
                        .filter(stud -> stud.getId().equals(id))
                        .findFirst().orElseThrow();
        return studentToGet;
    }

    public Student addStudent(Student student){
        this.students.add(student);
        return student;
    }

    public Student deleteStudentById(long id){
        Student deleteStudent =
        this.students.stream()
                .filter(stud -> stud.getId().equals(id))
                .findFirst().orElseThrow();

        students.remove(deleteStudent);

        return deleteStudent;
    }

    public List<Student> updateStudentById(long id, Student student) {
        Student updateStudent = getStudentById(id);
        updateStudent.setName(student.getName());
        updateStudent.setLastName(student.getLastName());
        updateStudent.setAge(student.getAge());

        return students;
    }

    public List<Student> patchStudentById(long id, Student student){
        Student studentByReplace = getStudentById(id);
        if (student.getId() != null){
            studentByReplace.setId(student.getId());
        }

        if (student.getName() != null){
            studentByReplace.setName(student.getName());
        }

        if (student.getLastName() != null){
            studentByReplace.setLastName(student.getLastName());
        }

        if (student.getAge() != 0){
            studentByReplace.setAge(student.getAge());
        }

        int indexOfStudent = this.students.indexOf(studentByReplace);
        this.students.set(indexOfStudent, studentByReplace);
        return this.students;

    }

}
