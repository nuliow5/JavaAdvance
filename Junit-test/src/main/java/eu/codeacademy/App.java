package eu.codeacademy;

public class App {
    public static void main( String[] args ) {

        String testTemp = reverseStringNewMethod("Labas");
        System.out.println(testTemp);

        System.out.println(10 / 0);
    }

    public static String reverseStringNewMethod(String value){
        String[] array = value.split("");

        String reverseValue = "";
        for (int i = array.length-1; i >=0 ; i--) {
            reverseValue += array[i];
        }
        return reverseValue;

    }


}
