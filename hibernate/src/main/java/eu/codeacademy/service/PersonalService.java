package eu.codeacademy.service;

import eu.codeacademy.view.VwPerson;
import org.hibernate.Session;

import java.util.List;

public class PersonalService {

    private final Session session;

    public PersonalService(Session session) {
        this.session = session;
    }

    public List<VwPerson> loadAll() {
        return session.createQuery("FROM VwPerson", VwPerson.class).list();
    }
}
