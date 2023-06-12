package eu.codeacademy.sum_of_digits;


import java.lang.reflect.Array;
import java.util.Arrays;

/*
Digital root is the recursive sum of all the digits in a number.
Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
The input will be a non-negative integer.

Examples
    16  -->  1 + 6 = 7
   942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */
public class SumOfDigit {
    public static void main(String[] args) {

        int result = digital_root(942);
        System.out.println(result);

    }

    public static int digital_root(int n) {

        while (true){
            if (n < 10 && n >= 0) {
                return n;
            }

            String number = String.valueOf(n);
            n = 0;
            for (int i = 0; i < number.length(); i++) {
                n += Character.digit(number.charAt(i), 10);
            }

        }

    }
}
