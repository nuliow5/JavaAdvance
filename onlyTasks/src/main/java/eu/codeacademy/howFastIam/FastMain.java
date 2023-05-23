package eu.codeacademy.howFastIam;

import java.util.*;

import static java.lang.Integer.parseInt;

public class FastMain {
    public static Scanner scanner = new Scanner(System.in);
    public static Map<Integer, List<Integer>> note = new HashMap<>();
    public static void main(String[] args) {

        while (true) {
            long startTime = System.currentTimeMillis();

            int fiboValue = parseInt(scanner.next());

            System.out.println(fibonacci(fiboValue, note));

            long endTime = System.currentTimeMillis();

            System.out.println("Total execution time: " + (endTime - startTime));
        }

    }

    public static List fibonacci(int elementOfFibonacci, Map<Integer, List<Integer>> note) {

        if (note.containsKey(elementOfFibonacci)) {
            System.out.println("have key");
            return note.get(elementOfFibonacci);
        }

        System.out.println("new key");
        List<Integer> fiboList = new ArrayList<>(Arrays.asList(0, 1));

        for (int i = 1; i < elementOfFibonacci - 1; i++) {
            int nextValue = fiboList.get(i - 1) + fiboList.get(i);
            fiboList.add(nextValue);
        }

        //save data to hash map
        note.put(elementOfFibonacci, fiboList);
//            for (Map.Entry<Integer, List<Integer>> entry : note.entrySet()) {
//                System.out.println(entry.getKey() + " - " + entry.getValue());
//            }


        return fiboList;


    }
}
