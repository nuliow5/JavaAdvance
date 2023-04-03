package eu.codeacademy;

import eu.codeacademy.animals.Animals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       Box<Integer> integerBox = new Box<>();
       Box<String> stringBox = new Box<>();

       integerBox.setObject(10);
       stringBox.setObject("Labas");

       Integer myValue = integerBox.getObject();
       String myValue2 = stringBox.getObject();

       List<Animals> animalsList = new ArrayList<>(List.of(new Animals()));

    }

    public static void printAnimalList (List<Animals> animalList){

    }
}
