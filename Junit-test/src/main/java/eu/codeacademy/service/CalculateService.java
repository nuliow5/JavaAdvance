package eu.codeacademy.service;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateService {

    public Integer findBiggestElement(List<Integer> myArray) {
        if (myArray == null || myArray.isEmpty()) {
            return null;
        }

        int max = myArray.get(0);

        for (int i = 0; i < myArray.size(); i++) {

            if (myArray.get(i) != null && (myArray.get(i) > max)) {
                max = myArray.get(i);
            }
        }

        return max;
    }

    public Integer calculate(int a, int b, char calculateSymbol) {
        if (calculateSymbol == '+') {
            return a + b;
        } else if (calculateSymbol == '-') {
            return a - b;
        } else if (calculateSymbol == '*') {
            return a * b;
        } else if (calculateSymbol == '/') {
            if (b != 0) {
                return a / b;
            } else {
                throw new ArithmeticException();
            }

        } else {
            System.out.println("Bad input");
            return null;
        }
    }

    public String reverseString(String value) {
        try {
            String valueAfterReverse = "";

            for (int i = value.length() - 1; i >= 0; i--) {
                valueAfterReverse += value.charAt(i);
            }

            return valueAfterReverse;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();

        }

    }

    //fibonacciSequence

    public Integer fibonacciSequence(Integer elementNumber) {
        if (elementNumber < 0) {
            return -1;
        }
        ArrayList<Integer> fibonacciArray = new ArrayList<>(Arrays.asList(0, 1));

        for (int i = 2; i <= elementNumber; i++) {
            int temp = fibonacciArray.get(i - 2) + fibonacciArray.get(i - 1);
            fibonacciArray.add(temp);
        }

        return fibonacciArray.get(elementNumber);
    }

    public Pair<Double, Double> solveQuadraticEquation(Integer a, Integer b, Integer c) {
        MutablePair<Double, Double> answers;

        if (a == null || b == null || c == null){
            throw new IllegalArgumentException("Ban input");
        }

        double root1, root2;
        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

            return answers = new MutablePair<>(root1, root2);

        } else if (determinant == 0) {
            root1 =  -b / (2 * a);
            return answers = new MutablePair<>(root1, null);

        } else {
            return answers = new MutablePair<>(null, null);
        }

    }

    public Integer countVowels(String word){
        String[] myWord = word.split("");
        String[] pattern = {"a", "e", "i", "o", "u"};
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (myWord[i].equals(pattern[j])) {
                    count++;
                }
            }
        }
        return count;

    }




}
