package eu.codeacademy.pojo;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_type")
public class EmployeeTypePojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    public String getName() {
        return name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
