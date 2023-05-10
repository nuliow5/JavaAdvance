package eu.codeacademy.dao;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class GenericDao<T> {
    private final Session session;
    private final Class<T> entityClass;

    //Dependency Injection (DI)
    public GenericDao(Session session, Class<T> entityClass) {
        this.session = session;
        this.entityClass = entityClass;
    }

    //listas veikia kaip optional, tai nepavojinga, jeigu gausime null reiksmes.
    public List<T> loadAll() {
        return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
    }

    //Optiona jeigu grazintu null, isves tuscia Optional
    public Optional<T> getById(Long id) {
        return Optional.ofNullable(session.get(entityClass, id));
    }

    public void delete(Long id) {
        getById(id).ifPresent(session::remove);
    }

    public void saveOrUpdate(T t) {
        session.persist(t);
    }

}
