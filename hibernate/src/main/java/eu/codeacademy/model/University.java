package eu.codeacademy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "university")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "establishmentYear", nullable = false)
    private Integer establishmentYear;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rector_id")
    private Rector rector;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    private List<Person> persons;


}
