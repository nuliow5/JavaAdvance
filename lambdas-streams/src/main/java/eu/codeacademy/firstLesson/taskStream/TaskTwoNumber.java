package eu.codeacademy.firstLesson.taskStream;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class TaskTwoNumber {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);

        System.out.println(returnMinMan(numbers));

        System.out.println(returnMinMaxWithPair(numbers));


    }

    public static HashMap<String, Integer> returnMinMan(List<Integer> list) {
        Collections.sort(list);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("MAX", list.get(list.size() - 1));
        map.put("MIN", list.get(0));
        return map;
    }

    public static Pair<Integer, Integer> returnMinMaxWithPair(List<Integer> list) {
        Collections.sort(list);
        Pair<Integer, Integer> result;
        int min = list.get(0);
        int max = list.get(list.size() - 1);

        return result = new MutablePair<>(min, max);


    }


}
