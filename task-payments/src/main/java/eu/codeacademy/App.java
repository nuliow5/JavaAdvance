package eu.codeacademy;

import eu.codeacademy.service.PeopleService;

import java.util.*;

public class App {
    public static void main(String[] args) {
        PeopleService peopleService = new PeopleService();
        Map<String, Person> personMap = peopleService.writeToMapFromFile();

        peopleService.printAllPeopleMap((HashMap<String, Person>) personMap);

        System.out.println("-------------------");

        peopleService.payment(personMap);
        peopleService.printAllPeopleMap((HashMap<String, Person>) personMap);

        peopleService.writeToFieBySendMoney(personMap);

        //-----------write to file from concertinted Map to list
        peopleService.writeToFieBySendMoneyUsingList(peopleService.convertMapToList(personMap));
    }
}
