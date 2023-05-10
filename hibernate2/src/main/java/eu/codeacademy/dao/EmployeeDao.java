package eu.codeacademy.dao;

import eu.codeacademy.pojo.EmployeePojo;
import org.hibernate.Session;

public class EmployeeDao extends GenericDao<EmployeePojo>{
    public EmployeeDao(Session session, Class<EmployeePojo> entityClass) {
        super(session, entityClass);
    }
}
