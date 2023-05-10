package eu.codeacademy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "student_contacts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @Column(name = "phone_number", length = 16)
    private String phoneNumber;
    @Column(length = 100)
    private String email;

    @OneToOne(mappedBy = "studentContact", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Student student;
}
