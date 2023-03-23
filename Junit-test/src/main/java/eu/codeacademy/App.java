package eu.codeacademy;

import eu.codeacademy.service.CalculateService;

public class App {
    public static void main( String[] args ) {

//        String testTemp = reverseStringNewMethod("Labas");
//        System.out.println(testTemp);
//
//        System.out.println(10 / 0);
//
//        CalculateService calculateService = new CalculateService();
//        System.out.println(calculateService.fibonacciSequence(1));


//        solveQuadraticEquation123(5, 6, 3);
        int count = new CalculateService().countVowels("Palm");
        System.out.println(count);


    }

    public static String reverseStringNewMethod(String value){
        String[] array = value.split("");

        String reverseValue = "";
        for (int i = array.length-1; i >=0 ; i--) {
            reverseValue += array[i];
        }
        return reverseValue;

    }

    public static void solveQuadraticEquation123(Integer a, Integer b, Integer c) {
        double root1, root2;
        double determinant = b * b - 4 * a * c;

        if (determinant > 0) {
            // two real and distinct roots
            root1 = (-b + Math.sqrt(determinant)) / (2 * a);
            root2 = (-b - Math.sqrt(determinant)) / (2 * a);

            System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);

        } else if (determinant == 0) {
            root1 = root2 = -b / (2 * a);
            System.out.format("root1 = root2 = %.2f;", root1);

        } else {
            // roots are complex number and distinct
            double real = -b / (2 * a);
            double imaginary = Math.sqrt(-determinant) / (2 * a);
            System.out.format("root1 = %.2f+%.2fi", real, imaginary);
            System.out.format("\nroot2 = %.2f-%.2fi", real, imaginary);
        }


    }


}
