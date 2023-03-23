package eu.codeacademy.fibonacci;

import eu.codeacademy.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciSequenceTest {

    private static CalculateService calculatorService;

    @BeforeAll
    static void setUp(){
        calculatorService = new CalculateService();
    }
    @Test
    void fibonacciSequenceFirstElementTest() {
        Integer number = calculatorService.fibonacciSequence(1);
        assertEquals(number, 1);
    }

    @Test
    void fibonacciSequenceSecondElementTest() {
        Integer number = calculatorService.fibonacciSequence(2);
        assertEquals(number, 1);
    }

    @Test
    void fibonacciSequenceNegativeElementTest() {
        Integer number = calculatorService.fibonacciSequence(-100);
        assertEquals(number, -1);
    }

    @Test
    void fibonacciSequenceSeventhElementTest() {
        Integer number = calculatorService.fibonacciSequence(7);
        assertEquals(number, 13);
    }

    @Test
    void fibonacciSequenceTwelfthElementTest() {
        Integer number = calculatorService.fibonacciSequence(12);
        assertEquals(number, 144);
    }
}
