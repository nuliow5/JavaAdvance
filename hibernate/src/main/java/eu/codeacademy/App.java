package eu.codeacademy;

import eu.codeacademy.service.RegitraService;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        RegitraService regitraService = new RegitraService();
        ArrayList persons = regitraService.findAllPersons();
        System.out.println(persons);

        regitraService.findAllAuto();

        regitraService.findPersonByCar("audi");

        Person firstPerson = new Person(11,
                "Vadimas",
                "Gerasimovas",
                35);

//        regitraService.insertIntoNewPersonToSQL(firstPerson);

//        regitraService.updatePersonNameById(3, "Aaaa");

        regitraService.moveAllFirstPersonCarsToSecondPerson("petras", "antanas");


    }
}
