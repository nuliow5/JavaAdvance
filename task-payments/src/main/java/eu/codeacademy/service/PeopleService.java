package eu.codeacademy.service;

import eu.codeacademy.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PeopleService {
    private final String PEOPLE_INFO_PATH = "task-payments\\src\\main\\java\\eu\\codeacademy\\file\\people.txt";
    private final String PAYMENT = "task-payments\\src\\main\\java\\eu\\codeacademy\\file\\payment.txt";
    private Map<String, Person> personMap = writeToMapFromFile();


    public Map<String, Person> writeToMapFromFile() {
        HashMap<String, Person> map = new HashMap<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(PEOPLE_INFO_PATH))) {
            while ((line = reader.readLine()) != null) {
                String[] splitToArray = line.split(", ");
                map.put(splitToArray[0],
                        (new Person(
                                splitToArray[0],
                                splitToArray[1],
                                splitToArray[2].trim())));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map<String, Person> getPersonMap() {
        return personMap;
    }

    public void printAllPeopleMap(HashMap<String, Person> map) {

        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println(map.get(entry.getKey()).getId() + " "
                    + map.get(entry.getKey()));
        }
    }

    //payment
    public void payment( Map<String, Person> personMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PAYMENT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitToArray = line.split(", ");
                for (Map.Entry<String, Person> entry : personMap.entrySet()){
                    if (entry.getKey().equals(splitToArray[2])){
                        personMap.get(entry.getKey()).setSentMoney(Integer.parseInt(splitToArray[2]));
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
