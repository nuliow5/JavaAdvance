package eu.codeacademy.helper;

import eu.codeacademy.pojo.EmployeePojo;
import eu.codeacademy.pojo.EmployeeTypePojo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoManagerHelper {
    public static SessionFactory getSessionFactory() {
        Configuration cfg = HibernateConfigurationHelper.iniConfigurationPostgreSQL();
        cfg.addAnnotatedClass(EmployeePojo.class);
        cfg.addAnnotatedClass(EmployeeTypePojo.class);


        return cfg.buildSessionFactory();
    }
}
