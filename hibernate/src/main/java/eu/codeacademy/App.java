package eu.codeacademy;

import eu.codeacademy.model.University;
import eu.codeacademy.service.RegitraService;
import eu.codeacademy.service.RegitraServiceWithHibernate;
import eu.codeacademy.service.UniversityService;
import org.hibernate.SessionFactory;

public class App {
    private static SessionFactory factory;

    public static void main(String[] args) {
        RegitraService regitraService = new RegitraService();
//        ArrayList persons = regitraService.findAllPersons();
//        System.out.println(persons);
//
//        regitraService.findAllAuto();
//
//        regitraService.findPersonByCar("audi");
//
//        Person firstPerson = new Person(11,
//                "Vadimas",
//                "Gerasimovas",
//                35);
//
////        regitraService.insertIntoNewPersonToSQL(firstPerson);
//
////        regitraService.updatePersonNameById(3, "Aaaa");
//
//        regitraService.moveAllFirstPersonCarsToSecondPerson("petras", "antanas");

        RegitraServiceWithHibernate regitraServiceWithHibernate = new RegitraServiceWithHibernate();
//        regitraServiceWithHibernate.insertIntoPerson();

        University myUniversity = new University(null,
                "VDU",
                "1961");

        UniversityService universityService = new UniversityService();

//        universityService.createUniversity(myUniversity);
//        universityService.showAllUniversity();
//        regitraServiceWithHibernate.showAllPersons();
//        universityService.updateUniversityName();
//        universityService.selectUniversityById(1L);
//        universityService.selectPersonByIdAnotherMethod(1L);

        University university1 = new University(null, "UUUUU", "1111");
        universityService.updateUniversityNameById(1L, university1);

    }
}
