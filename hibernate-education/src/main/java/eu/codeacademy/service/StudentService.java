package eu.codeacademy.service;

import eu.codeacademy.model.Student;
import eu.codeacademy.model.StudentContact;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import eu.codeacademy.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;


public class StudentService {
    /*
        + create student
        + update student by id
        + update student by id and StudentContact_id
        + find student by course
        - print student info with StudentContact

        Join: OneToOne, OneToMany
     */

    public Student createStudent(String name, String surname, int age, int course){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);
        student.setCourse(course);

        session.persist(student);
        transaction.commit();

        return student;
    }

    public Student updateStudentById(Long id, Student newStudent){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        Student student = session.find(Student.class, id);
        student.setName(newStudent.getName());
        student.setSurname(newStudent.getSurname());
        student.setAge(newStudent.getAge());
        student.setCourse(newStudent.getCourse());

        return student;
    }

    public Student updateStudentByIdAndContactId(Long studentId, Long contactId){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.find(Student.class, studentId);
        StudentContact studentContact = session.find(StudentContact.class, contactId);

        student.setStudentContact(studentContact);
        session.persist(student);
        transaction.commit();

        return student;
    }

    public List<Student> findStudentsByCourse(Integer course){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("course"), course));

        Query<Student> query = session.createQuery(criteriaQuery);
        List<Student> studentList = query.getResultList();

        return studentList;

    }

}
