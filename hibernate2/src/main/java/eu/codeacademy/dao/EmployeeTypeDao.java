package eu.codeacademy.dao;

import eu.codeacademy.pojo.EmployeeTypePojo;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeTypeDao extends GenericDao<EmployeeTypePojo>{

    public EmployeeTypeDao(Session session, Class<EmployeeTypePojo> entityClass) {
        super(session, entityClass);
    }
}
