package eu.codeacademy.countVowels;

import eu.codeacademy.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountVowelsTest {
    private static CalculateService calculateService;
    @BeforeAll
    static void setUp(){
        calculateService = new CalculateService();
    }
    @Test
    void countVowelsCelebration() {
        Integer vowels = calculateService.countVowels("Celebtration");
        assertEquals(vowels, 5);
    }

    @Test
    void countVowelsPalm() {
        Integer vowels = calculateService.countVowels("Palm");
        assertEquals(vowels, 1);
    }

    @Test
    void countVowelsPrediction() {
        Integer vowels = calculateService.countVowels("Prediction");
        assertEquals(vowels, 4);
    }
}
