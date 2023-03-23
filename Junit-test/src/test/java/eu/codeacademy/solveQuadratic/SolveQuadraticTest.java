package eu.codeacademy.solveQuadratic;

import eu.codeacademy.service.CalculateService;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SolveQuadraticTest {
    private static CalculateService calculateService;
    @BeforeAll
    static void setUp(){
        calculateService = new CalculateService();
    }
    @Test
    void solveQuadraticEquationNoAnswersTest() {
        Pair<Double, Double> answer = calculateService.solveQuadraticEquation(5,6,3);

        assertNull(answer.getLeft());
        assertNull(answer.getRight());
    }

    @Test
    void solveQuadraticEquationOneAnswerTest() {
        Pair<Double, Double> answer = calculateService.solveQuadraticEquation(1,4,4);

        assertEquals(answer.getLeft(), -2.0);
        assertNull(answer.getRight());
    }

    @Test
    void solveQuadraticEquationTwoAnswersTest() {
        Pair<Double, Double> answer = calculateService.solveQuadraticEquation(1,7,6);

        assertEquals(answer.getLeft(), -1.0);
        assertEquals(answer.getRight(), -6.0);
    }

    @Test
    void solveQuadraticNullPoint() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> {
            calculateService.solveQuadraticEquation(1, 2, null);
        });

    }
}
