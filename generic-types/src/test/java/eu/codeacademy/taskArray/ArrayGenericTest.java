package eu.codeacademy.taskArray;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;


public class ArrayGenericTest {

    @Test
    void addStringElementToGenericList(){
        ArrayGeneric<String> stringArray = new ArrayGeneric<>();
        stringArray.add("labas");
        stringArray.add("miau");
        stringArray.add("OP");

        assertEquals("labas", stringArray.get(0));
        assertEquals("miau", stringArray.get(1));
        assertEquals("OP", stringArray.get(2));
    }
    @Test
    void addIntegerElementToGenericList(){
        ArrayGeneric<Integer> intArray = new ArrayGeneric<>();
        intArray.add(10);
        intArray.add(0);
        intArray.add(-1);
        intArray.add(null);


        assertEquals(10, intArray.get(0).intValue());
        assertEquals(0, intArray.get(1).intValue());
        assertEquals(-1, intArray.get(2).intValue());
        assertNull(intArray.get(3));
    }
}
