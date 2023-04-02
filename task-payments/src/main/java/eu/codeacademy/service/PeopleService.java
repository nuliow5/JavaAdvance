package eu.codeacademy.service;

import eu.codeacademy.Person;

import java.io.*;
import java.util.*;

public class PeopleService {
    private final String PEOPLE_INFO_PATH = "task-payments\\src\\main\\java\\eu\\codeacademy\\file\\people.txt";
    private final String PAYMENT = "task-payments\\src\\main\\java\\eu\\codeacademy\\file\\payment.txt";
    private final String PAYMENT_COMPARATOR = "task-payments\\src\\main\\java\\eu\\codeacademy\\file\\payment_comparator.txt";
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
    public void payment(Map<String, Person> personMap) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PAYMENT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitToArray = line.split(", ");
                for (Map.Entry<String, Person> entry : personMap.entrySet()) {
                    if (entry.getKey().equals(splitToArray[2])) {
                        personMap.get(entry.getKey()).setSentMoney(Integer.parseInt(splitToArray[1]));
                    }
                    if (entry.getKey().equals(splitToArray[3].trim())) {
                        personMap.get(entry.getKey()).setReceivedMoney(Integer.parseInt(splitToArray[1]));
                    }
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Map.Entry<String, Person>> convertMapToList(Map<String, Person> personMap) {
        List<Map.Entry<String, Person>> list = new ArrayList<>(personMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Person>>() {
            @Override
            public int compare(Map.Entry<String, Person> o1, Map.Entry<String, Person> o2) {
                return o1.getValue().getSentMoney() - o2.getValue().getSentMoney();
            }
        });

        return list;
    }

    public void writeToFieBySendMoney(Map<String, Person> personMap) {
          try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PAYMENT_COMPARATOR))) {
            for (Map.Entry<String, Person> entry : personMap.entrySet()) {
                bufferedWriter.write(entry.toString() + "\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFieBySendMoneyUsingList(List<Map.Entry<String, Person>> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PAYMENT_COMPARATOR))) {
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i) + "\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
