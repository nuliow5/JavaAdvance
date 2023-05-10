package eu.codeacademy.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "owner")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // IDENTITY because postgresql
    private Long id;

    private String name;
    private String surname;

    @Column(name = "year_of_birth")
    private String yearOfBirth;





}
