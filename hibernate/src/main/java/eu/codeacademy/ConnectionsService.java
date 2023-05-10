package eu.codeacademy;

import eu.codeacademy.model.Rector;
import eu.codeacademy.model.StudentContact;
import eu.codeacademy.model.University;

import eu.codeacademy.service.UniversityService;
import org.hibernate.SessionFactory;

public class ConnectionsService {
    private static SessionFactory factory;
    public static void main(String[] args) {

        Rector rector = new Rector();
        rector.setAge(60);
        rector.setName("Rektorius");
        rector.setSurname("Pavardenis");
//
//        University university = new University(null, "VGDULT", 2023, rector);
//
        UniversityService us = new UniversityService();
//
        us.insertIntoRector(rector);
//
////        us.updateUniversityNameById(1L, university);
//
////        us.createUniversity(university);
//
        us.updateUniversity(1L, 1L);

        StudentContact studentContact = new StudentContact();
        studentContact.setAddress("Kalantos 49");
        studentContact.setEmail("test@gmail.com");
        studentContact.setPhoneNumber("+3706666666");

        us.insertIntoStudentContact(studentContact);
        us.updatePerson(3L, 1L);

        us.printPersonByAge(37);

        us.updatePersonByUniversity(3L,1L);



    }

}
