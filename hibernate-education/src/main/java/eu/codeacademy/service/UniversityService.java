package eu.codeacademy.service;

import eu.codeacademy.model.University;
import eu.codeacademy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UniversityService {
    /*
        - create uni
        - update uni by id
        - update uni by id and rector_id
        - find uni by years
        - print uni info with Rector
     */
    public University createUniversity(String name, Integer establishmentYear){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        University university = new University();
        university.setName(name);
        university.setEstablishmentYear(establishmentYear);

        session.persist(university);
        transaction.commit();
        return university;
    }

    public University updateUniversityById(Long universityId, University newUniversity){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        University university = session.find(University.class, universityId);
        university.setName(newUniversity.getName());
        university.setEstablishmentYear(newUniversity.getEstablishmentYear());

        session.persist(university);
        transaction.commit();
        return university;
    }


//    public University updateUniByIdAndRectorId(Long universityId, Long rectorId){
//        SessionFactory factory = HibernateUtil.getSessionFactory();
//        Session session = factory.openSession();
//
//
//
//
//    }




}
