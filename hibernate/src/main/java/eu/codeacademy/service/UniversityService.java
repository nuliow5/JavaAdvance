package eu.codeacademy.service;

import eu.codeacademy.model.Person;
import eu.codeacademy.model.Rector;
import eu.codeacademy.model.StudentContact;
import eu.codeacademy.model.University;
import eu.codeacademy.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UniversityService {
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private Session session = factory.openSession();
    private Transaction transaction = session.beginTransaction();

    public void createUniversity(University university) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(university);
        transaction.commit();
    }

    public void showAllUniversity() {
        Query query = session.createQuery("from University");

        List list = query.list();

        System.out.println(list);
    }


    //1 budas
    public void updateUniversityName() {
        Query query = session.createQuery("update University set name=:name where id=:id");
        query.setParameter("name", "TestUniverstity");
        query.setParameter("id", 1);
        query.executeUpdate();
        transaction.commit();
    }

    //2 budas update
    public University updateUniversityNameById(Long id, University newUniversity) {

        University university = session.find(University.class, id);

        university.setName(newUniversity.getName());
        university.setEstablishmentYear(newUniversity.getEstablishmentYear());

        session.persist(university);
        transaction.commit();
        System.out.println(university.toString());
        return university;
    }


    //1 budas
    public void selectUniversityById(Long id) {
        Query query = session.createQuery("from University where id=:id");
        query.setParameter("id", id);
        List list = query.list();
        System.out.println(list);
    }

    //2 budas Aukstesnis lygis
    public void selectPersonByIdAnotherMethod(Long id) {
        Person person = session.find(Person.class, id);
        transaction.commit();
        System.out.println(person.toString());
    }

    public void insertIntoRector(Rector rector) {
        session.persist(rector);
        transaction.commit();
    }

    public University updateUniversity(Long id, Long rectorId) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        University university = session.find(University.class, id);


        Rector rector = session.find(Rector.class, rectorId);
        university.setRector(rector);

        session.persist(university);
        transaction.commit();


        return university;

    }

    public void insertIntoStudentContact(StudentContact studentContact) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(studentContact);
        transaction.commit();
    }


    public Person updatePerson(Long id, Long studentPersonId) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Person person = session.find(Person.class, id);


        StudentContact studentContact = session.find(StudentContact.class, studentPersonId);
        person.setStudentContact(studentContact);

        session.persist(person);
        transaction.commit();


        return person;
    }


    public void printPersonByAge(Integer age) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> cr = cb.createQuery(Person.class);
        Root<Person> root = cr.from(Person.class);
        cr.select(root).where(cb.equal(root.get("age"), age));

        Query<Person> query = session.createQuery(cr);
        Person person = query.getSingleResult();

        System.out.println("Person: " + person.getName());

        System.out.println(person.getStudentContact().getAddress() +
                "\n" + person.getStudentContact().getEmail() +
                "\n" + person.getStudentContact().getPhoneNumber());

    }

    public Person updatePersonByUniversity(Long id, Long universityId) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Person person = session.find(Person.class, id);


        University university = session.find(University.class, universityId);
        person.setUniversity(university);

        session.persist(person);
        transaction.commit();


        return person;

    }





}
