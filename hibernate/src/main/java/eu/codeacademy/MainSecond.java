package eu.codeacademy;

import eu.codeacademy.model.Person;
import eu.codeacademy.service.PersonSelectLogic;
import java.util.List;

public class MainSecond {
    public static void main(String[] args) {
        List<Person> persons = PersonSelectLogic.findPersonByAge(18);
        System.out.println(persons);

        System.out.println(PersonSelectLogic.findUniversitiesByEstablishmentYearGreater(1961));

        System.out.println(PersonSelectLogic.findStudentsByNameLike("KUg"));

        System.out.println(PersonSelectLogic.findStudentsByAgeAndName(37, "Vadimas"));


    }
}
