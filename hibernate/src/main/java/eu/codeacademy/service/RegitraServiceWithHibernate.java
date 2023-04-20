package eu.codeacademy.service;

import eu.codeacademy.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.awt.desktop.QuitEvent;
import java.util.List;

public class RegitraServiceWithHibernate {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();;
    private Session session = factory.openSession();
    private Transaction transaction = session.beginTransaction();

    public void insertIntoPerson(){
        Person naujas = new Person();

        naujas.setName("Vardas");
        naujas.setSurname("Pavarde");
        naujas.setAge(99);
        session.persist(naujas);
        transaction.commit();
    }

    public void showAllPersons(){
        Query query = session.createQuery("from Person ");
        List list = query.list();

        System.out.println(list);
    }
}
