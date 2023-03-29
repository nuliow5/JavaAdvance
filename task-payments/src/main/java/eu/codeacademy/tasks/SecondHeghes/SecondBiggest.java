package eu.codeacademy.tasks.SecondHeghes;

import java.util.*;

public class SecondBiggest {
    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 10, 5, 7, 9));
//        List<Integer> myList = new ArrayList<>();
        System.out.println(myList);

        System.out.println(findSecondHighestNumber(myList));
        System.out.println(myList);
    }

    public static Integer findSecondHighestNumber(List<Integer> list){
        if (list == null){
            return null;
        }

        if (list.size() >=0 && list.size() <=1){
            throw new IllegalArgumentException("At least 2 numbers has to be present");
        }

        Collections.sort(list);
        return list.get(list.size()-2);
    }




}
