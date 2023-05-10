package eu.codeacademy.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY because postgresql
    private Long id;

    private String name;
    @Column(name = "bar_code")
    private Integer barCode;

    private float price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_product")
    private List<Department> departments = new ArrayList<>();


}
