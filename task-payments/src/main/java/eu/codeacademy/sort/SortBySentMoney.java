package eu.codeacademy.sort;

import eu.codeacademy.Person;

import java.util.Comparator;

public class SortBySentMoney implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSentMoney() - o2.getSentMoney();
    }
}
