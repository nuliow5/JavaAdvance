package eu.codeacademy.taskGeneric;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PersonListBoxTest {

    @Test
    void addElementsWhenInitialListEmpty() {
        Person[] values = new Person[2];
        values[0] = new Person("Vardemis", 23);
        values[1] = new Person("Mantas", 11);

        PersonListBox personListBox = new PersonListBox(new ArrayList());
        personListBox.addElements(values);

        List<Person> personList = personListBox.getElements();
        assertEquals(2, personList.size());
        assertEquals("Vardemis", personList.get(0).getName());
        assertEquals("Mantas", personList.get(1).getName());
    }



}
