package eu.codeacademy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "age", nullable = false)
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_contact_id")
    private StudentContact studentContact;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "university")
    private University university;


}
