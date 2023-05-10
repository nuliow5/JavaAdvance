package eu.codeacademy.pojo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
@ToString
public class CityPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "cities")
    @ToString.Exclude
    private List<EmployeePojo> employees = new ArrayList<>();


}
