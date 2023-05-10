package eu.codeacademy.service;

import eu.codeacademy.dao.EmployeeDao;
import eu.codeacademy.pojo.EmployeePojo;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;

    public List<EmployeePojo> getAll(){
        return employeeDao.loadAll();
    }

}
