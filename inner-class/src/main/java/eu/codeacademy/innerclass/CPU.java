package eu.codeacademy.innerclass;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class CPU {
    private double price;



    @Value
    class Processor {
        private double core;
        private String manufacture;
    }

    @Value
    protected static class RAM {
        protected double memory;
        private String manufacture;


    }


}
