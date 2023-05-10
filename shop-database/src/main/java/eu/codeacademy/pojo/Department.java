package eu.codeacademy.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY because postgresql
    private Long id;

    @Column(name = "year_of_establishment")
    private Integer yearOfEstablishment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;

    @ManyToMany(mappedBy = "departments")
    @ToString.Exclude
    private List<Product> products = new ArrayList<>();



}
