package eu.codeacademy.model;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "module")
@ToString
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private int credits;

    @ManyToOne(cascade = CascadeType.MERGE)
    private University university;


}
