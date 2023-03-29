package eu.codeacademy.tasks.SecondHighes;

import eu.codeacademy.tasks.SecondHeghes.SecondBiggest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecondBiggestTest {

    private static SecondBiggest secondBiggest;
    @BeforeAll
    static void setUp(){
        secondBiggest = new SecondBiggest();
    }

    @Test
    void findSecondHighestNumberThreeNumbersTest() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2,4,3));
        Integer number = secondBiggest.findSecondHighestNumber(numbers);

        assertEquals(number, 3);
    }

    @Test
    void findSecondHighestNumberTwoNumbersTest() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2,3));
        Integer number = secondBiggest.findSecondHighestNumber(numbers);

        assertEquals(number, 2);
    }

    @Test
    void findSecondHighestNumberLessThanTwoNumbersTest() {

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(2));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            secondBiggest.findSecondHighestNumber(numbers);
        });

        assertEquals(exception.getMessage(), "At least 2 numbers has to be present");

    }

    @Test
    void findSecondHighestNumberLessThanTwoNumbersTestForVadimas() {

        ArrayList<Integer> numbers = new ArrayList<>();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            secondBiggest.findSecondHighestNumber(numbers);
        });

        assertEquals(exception.getMessage(), "At least 2 numbers has to be present");

    }
}
