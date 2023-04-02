package eu.codeacademy.firstLesson.taskStream;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class SortSecondTask {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

//        1. sukurti nauja sarasa, kuris butu visu siu skaiciu kvadratai (81, 100, 9, 16, 49, 9, 16)
        List<Integer> returnSquaredElemens =
                numbers.stream()
                        .map((value) -> value * value)
                        .collect(Collectors.toList());
        System.out.println("returnSquaredElemens = " + returnSquaredElemens);

//        2. surasti, ar visi skaiciai yra didesni uz 5
        Boolean doesAllElementsIsBiggestThatFive =
                numbers.stream()
                        .allMatch((value) -> value > 5);

        System.out.println("doesAllElementsIsBiggestThatFive = " + doesAllElementsIsBiggestThatFive);

//        3. atfiltruoti visus lyginius skaicius, kurie yra didesni uz 5
        List<Integer> evenNumbersGreaterThanFive =
                numbers.stream()
                        .filter((intValue) -> (intValue % 2 == 0) && (intValue > 5))
                        .collect(Collectors.toList());

        System.out.println("evenNumbersGreaterThanFive = " + evenNumbersGreaterThanFive);

//        4. surasti didziausia/maziausia skaicius
        Integer findMin =
                numbers.stream()
//                        .collect(new HashMap<>().put("max", numbers.stream().max(Comparator.comparing(Integer::valueOf)).get());
                        .min(Comparator.comparing(Integer::valueOf)).get();

        System.out.println("findMinMax = " + findMin);


//        5. is List<Integer> paversti i List<String> kuris prie kiekvieno elemento pridetu zodi Number (Number 9, Number 10, Number 3)

        List<String> convertToStringList =
                (List<String>) numbers.stream()
                        .map(value -> "Number " + value)
                        .collect(Collectors.toList());
        System.out.println("convertToStringList = " + convertToStringList);


        //*Su HashMap surasti didziausia/maziausia skaicius
//        Map<String, Integer> maxMin =
//                numbers.stream()
//                        .collect(Collectors.toMap())
    }
}
