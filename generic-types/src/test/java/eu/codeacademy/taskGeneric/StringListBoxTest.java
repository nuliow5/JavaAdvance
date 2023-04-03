package eu.codeacademy.taskGeneric;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringListBoxTest {
    @Test
    void addElementsWhenInitialListEmpty() {
        String[] values = new String[2];
        values[0] = "a";
        values[1] = "b";

        StringListBox stringListBox = new StringListBox(new ArrayList<>());
        stringListBox.addElements(values);

        List<String> stringList = stringListBox.getElements();
        assertEquals(2, stringList.size());
        assertEquals("a", stringList.get(0));
        assertEquals("b", stringList.get(1));
    }

    @Test
    void addElementsWhenInitialListNotEmpty() {
        String[] values = new String[2];
        values[0] = "a";
        values[1] = "b";

        List<String> initial = new ArrayList<>(Arrays.asList("Vienas", "Du"));
        StringListBox stringListBox = new StringListBox(initial);
        stringListBox.addElements(values);

        List<String> stringList = stringListBox.getElements();
        assertEquals(4, stringList.size());
        assertEquals("Vienas", stringList.get(0));
        assertEquals("Du", stringList.get(1));
        assertEquals("a", stringList.get(2));
        assertEquals("b", stringList.get(3));
    }

    @Test
    void addElementWhenInitialListIsEmpty() {
        StringListBox stringListBox = new StringListBox(new ArrayList<>());
        stringListBox.addElement("a");

        List<String> stringList = stringListBox.getElements();
        assertEquals(1, stringList.size());
        assertEquals("a", stringList.get(0));
    }

    @Test
    void addElementWhenInitialListIsNotEmpty() {
        List<String> initial = new ArrayList<>(Arrays.asList("Vienas", "Du"));
        StringListBox stringListBox = new StringListBox(initial);
        stringListBox.addElement("a");

        List<String> stringList = stringListBox.getElements();
        assertEquals(3, stringList.size());
        assertEquals("Vienas", stringList.get(0));
        assertEquals("Du", stringList.get(1));
        assertEquals("a", stringList.get(2));
    }
}
