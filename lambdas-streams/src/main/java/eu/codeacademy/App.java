package eu.codeacademy;

import eu.codeacademy.firstLesson.LamdaFirstLesson;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        LamdaFirstLesson lamdaFirstLesson = (first, second) -> {
            System.out.println(first);
            System.out.println(second);
        };

        lamdaFirstLesson.print("pirmas", "antras");

        Consumer<Integer> square = (x) -> System.out.println(x * x);

        square.accept(4);

        Supplier<String> randomUUID = () -> UUID.randomUUID().toString();
        System.out.println(randomUUID.get());

        Predicate<String> containSymbol = (word) -> word.contains("a");
        System.out.println(containSymbol.test("labas"));

        Predicate<Integer> isBiggerThatFive = (intValue) -> intValue > 5;
        System.out.println(isBiggerThatFive.test(10));

        Function<Integer, Double> doubleNumber = (number) -> (double) (number * 2);
        System.out.println("Function = " + doubleNumber.apply(5));

    }


}
