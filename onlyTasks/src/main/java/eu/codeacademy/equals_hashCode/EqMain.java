package eu.codeacademy.equals_hashCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person("Antanas", 16);
        Person person2 = new Person("Antanas", 16);

        System.out.println(person1.equals(person2));

        System.out.println("P1-> " + person1);
        System.out.println("P2-> " + person2);
        System.out.println(person1 == person2);

        System.out.println("-------------");
        List<Person> persons = new ArrayList<>();

        persons.add(person1);
        persons.add(person2);
        System.out.println(persons);

        persons.remove(person2);
        System.out.println(persons);

        System.out.println("------hash------");

        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);

        System.out.println(personSet);

        System.out.println("---clone----");

        Person clonePerson = person1.clone();
        System.out.println(person1.hashCode());
        System.out.println(clonePerson.hashCode());
        System.out.println(person1.equals(clonePerson));

        System.out.println("---------------");

        System.out.println(new Worker().sayHi());


    }



}
