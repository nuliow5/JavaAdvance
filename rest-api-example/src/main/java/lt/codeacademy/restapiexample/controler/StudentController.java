package lt.codeacademy.restapiexample.controler;

import lt.codeacademy.restapiexample.entity.Student;
import lt.codeacademy.restapiexample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") long id){
        return this.studentService.getStudentById(id);
    }
    //prideda nauja
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public Student deleteStudentById(@PathVariable long id){
        return this.studentService.deleteStudentById(id);
    }

    //put idedam nauja objekta vietoj esamo
    @PutMapping("/{id}")
    public List<Student> updateStudentById(@PathVariable long id, @RequestBody Student student){
        return this.studentService.updateStudentById(id, student);
    }

    //Patch pakeicio esmao objekto reiksme
    @PatchMapping("/{id}")
    public List<Student> patchStudentById(@PathVariable long id, @RequestBody Student student){
        return this.studentService.patchStudentById(id, student);
    }






}
