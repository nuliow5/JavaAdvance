package eu.codeacademy.testForMe;

public class CountProcess {
    public static void main(String[] args) {
        Long value = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            value += i;
            System.out.println(value);
        }
    }
}
