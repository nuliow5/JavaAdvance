package eu.codeacademy.service;

import eu.codeacademy.model.Person;
import eu.codeacademy.model.University;
import eu.codeacademy.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class PersonSelectLogic {
    public static List<Person> findPersonByAge(Integer age){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(root).where(cb.equal(root.get("age"), age));

        Query<Person> query = session.createQuery(criteriaQuery);
        List<Person> result = query.getResultList();
        return result;
    }

    public static List<University> findUniversitiesByEstablishmentYearGreater(Integer year){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<University> cr = cb.createQuery(University.class);
        Root<University> root = cr.from(University.class);
        cr.select(root).where(cb.equal(root.get("establishmentYear"), year));

        Query<University> query = session.createQuery(cr);
        List<University> universityList = query.getResultList();

        return universityList;



    }

    //kuris rastu studentus pagal vardo istrauka (panaudoti like operatoriu)
    public static List<Person> findStudentsByNameLike(String name){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = cb.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(root).where(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));

        Query<Person> query = session.createQuery(criteriaQuery);
        List<Person> result = query.getResultList();
        return result;

    }

    public static List<University> findUniversitiesByEstablishmentYearBetween(Integer yearFrom, Integer yearTo){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<University> cr = cb.createQuery(University.class);
        Root<University> root = cr.from(University.class);
        cr.select(root).where(cb.between(root.get("establishmentYear"), yearFrom, yearTo));

        Query<University> query = session.createQuery(cr);
        List<University> universityList = query.getResultList();

        return universityList;

    }

    public static List<Person> findStudentsByAgeAndName(Integer age, String name){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> cr = cb.createQuery(Person.class);
        Root<Person> root = cr.from(Person.class);
        cr.select(root).where(cb.and(
                cb.equal(root.get("name"), name),
                cb.equal(root.get("age"), age)
        ));

        Query<Person> query = session.createQuery(cr);
        List<Person> universityList = query.getResultList();

        return universityList;
    }





}
