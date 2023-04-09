package eu.codeacademy.theoryReaped.shop.myException;

public class Insufficient extends Exception{
    private Integer remainder;

    public Insufficient(Integer remainder) {
        this.remainder = remainder;
    }

    public Insufficient(String message, Integer remainder) {
        super(message);
        this.remainder = remainder;
    }
}
