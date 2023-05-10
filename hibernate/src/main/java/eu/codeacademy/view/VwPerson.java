package eu.codeacademy.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="vwperson")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class VwPerson {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "age")
    private int personAge;
    @Column(name = "person_name")
    private String personName;

    private String surname;
    @Column(name = "student_contact_id")
    private Long studentContactId;

    @Column(name = "university_id")
    private Long universityId;

    @Column(name = "university_name")
    private String universityName;
    @Column(name = "rector_id")
    private int rectorId;


}
