package eu.codeacademy.service;

import eu.codeacademy.model.Person;
import eu.codeacademy.model.University;
import eu.codeacademy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UniversityService {
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private Session session = factory.openSession();
    private Transaction transaction = session.beginTransaction();

    public void createUniversity(University university){

        session.persist(university);
        transaction.commit();
    }

    public void showAllUniversity(){
        Query query = session.createQuery("from University");

        List list = query.list();

        System.out.println(list);
    }



    //1 budas
    public void updateUniversityName(){
        Query query = session.createQuery("update University set name=:name where id=:id");
        query.setParameter("name","TestUniverstity");
        query.setParameter("id",1);
        query.executeUpdate();
        transaction.commit();
    }
    //2 budas update
    public University updateUniversityNameById(Long id, University newUniversity){
        University university = session.find(University.class, id);

        university.setName(newUniversity.getName());
        university.setEstablishmentYear(newUniversity.getEstablishmentYear());

        session.persist(university);
        transaction.commit();
        System.out.println(university.toString());
        return university;
    }


    //1 budas
    public void selectUniversityById(Long id){
        Query query = session.createQuery("from University where id=:id");
        query.setParameter("id", id);
        List list = query.list();
        System.out.println(list);
    }

    //2 budas Aukstesnis lygis
    public void selectPersonByIdAnotherMethod(Long id){
        Person person = session.find(Person.class, id);
        transaction.commit();
        System.out.println(person.toString());
    }


}
