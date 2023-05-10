package eu.codeacademy.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class EmployeePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY because postgresql
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 30, nullable = false)
    private String surname;

    @Column(name = "phone_nuber", length = 8)
    private String phoneNumber;

    @Column(length = 10)
    private String test;

    @ManyToOne(fetch = FetchType.LAZY)  // by default EAGER, using EAGER is bad practic
    @JoinColumn(name = "employee_type_id")
    private EmployeeTypePojo employeeTypePojo;

    @ManyToMany(fetch = FetchType.LAZY)   // by default LAZY
    @JoinColumn(name = "employee_city")
    private List<CityPojo> cities = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_city_id")
    private CityPojo currentCity;


}
