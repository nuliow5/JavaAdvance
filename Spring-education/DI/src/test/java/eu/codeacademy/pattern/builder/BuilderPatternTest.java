package eu.codeacademy.pattern.builder;


import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;


public class BuilderPatternTest {
    @Test
    void createPersonSoldReturnNoChangedValues(){
        //given

        var builderPattern = new BuilderPattern();

        //when
        var result = builderPattern.createPerson("Petras", "Petraitis");

        //then
        assertEquals("Petras", result.getName());
        assertEquals("Petraitis", result.getSurname());
    }
}
