package eu.codeacademy.equals_hashCode;

public class NewString {
    public static void main(String[] args) {
        String firstValue = "Labas";

        String secondValue = new String("Labas");

        System.out.println(firstValue == secondValue);

        StringBuilder stringBuilder = new StringBuilder("Labas");

    }
}
