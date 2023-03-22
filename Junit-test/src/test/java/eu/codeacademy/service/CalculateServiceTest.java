package eu.codeacademy.service;

import org.junit.jupiter.api.Test;
import service.CalculateService;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculateServiceTest {
    @Test
    void findBiggestElement(){
        CalculateService calculateService = new CalculateService();
        ArrayList<Integer> integerArrayList=
                new ArrayList<>(Arrays.asList(99, 5, 7, 5, 15, null));

        Integer maxNumber = calculateService.findBiggestElement(integerArrayList);
        assertEquals(maxNumber, 99);
    }

    @Test
    void findBiggestIfArrayIsNull(){
        CalculateService calculateService = new CalculateService();
        ArrayList<Integer> integerArrayList=
                new ArrayList<>(Arrays.asList());

        Integer maxNumber = calculateService.findBiggestElement(integerArrayList);
        assertNull(maxNumber);
    }

    @Test
    void calculatePlus(){
        CalculateService calculateService = new CalculateService();
        Integer result = calculateService.calculate(10, 5, '+');
        assertEquals(result, 15);
    }

    @Test
    void calculateMinus(){
        CalculateService calculateService = new CalculateService();
        Integer result = calculateService.calculate(11, 5, '-');
        assertEquals(result, 6);
    }

    @Test
    void calculateMultiplication(){
        CalculateService calculateService = new CalculateService();
        Integer result = calculateService.calculate(10, 5, '*');
        assertEquals(result, 50);
    }

    @Test
    void calculateNull(){
        CalculateService calculateService = new CalculateService();
        Integer result = calculateService.calculate(10, 5, 's');
        assertEquals(result, null);
    }

    @Test
    void calculateDivideByZERO(){
        CalculateService calculateService = new CalculateService();
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculateService.calculate(10, 0, '/');
        });
    }

    @Test
    void reverseString(){
        CalculateService calculateService = new CalculateService();
        String reverse = calculateService.reverseString("Labas");
        assertEquals(reverse, "sabaL");
    }
//    @Test
//    void reverseStringNull(){
//        CalculateService calculateService = new CalculateService();
//        String reverse = calculateService.reverseString(null);
//        assertNull(reverse);
//    }

    @Test
    void reverseStringTestWithNull() {
        CalculateService calculateService = new CalculateService();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculateService.reverseString(null);
        });
    }
}
