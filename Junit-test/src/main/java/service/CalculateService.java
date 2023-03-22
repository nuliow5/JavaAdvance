package service;

import java.util.List;

public class CalculateService {

    public Integer findBiggestElement(List<Integer> myArray) {
        if (myArray == null || myArray.isEmpty()){
            return null;
        }

        int max = myArray.get(0);

        for (int i = 0; i < myArray.size(); i++) {

            if (myArray.get(i) != null && (myArray.get(i) > max )) {
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
            if (b != 0){
                return a / b;
            } else {
                throw new ArithmeticException();
            }

        } else {
            System.out.println("Bad input");
            return null;
        }
    }

    public String reverseString (String value){
        try{
            String valueAfterReverse = "";

            for (int i = value.length()-1; i >= 0 ; i--) {
                valueAfterReverse += value.charAt(i);
            }

            return valueAfterReverse;
        } catch (NullPointerException e){
            throw new IllegalArgumentException();

        }

    }

}
