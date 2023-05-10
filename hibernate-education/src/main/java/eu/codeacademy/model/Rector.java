package eu.codeacademy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "rector")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rector {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String surname;
    @Column(nullable = false)
    private int age;

    @OneToOne(mappedBy = "rector", cascade = CascadeType.ALL)
    @ToString.Exclude
    private University university;
}
