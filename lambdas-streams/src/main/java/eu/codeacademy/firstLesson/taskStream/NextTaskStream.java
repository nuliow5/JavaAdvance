package eu.codeacademy.firstLesson.taskStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NextTaskStream {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>(Arrays.asList("Zyzizu", "Saule", "Alus",
                "Sestadienis", "Pienas", "Duona"));

        System.out.println("====================================================\n" +
                                     "" + wordsList +
                         "\n====================================================\n");



//        1. atrinkti stringus, kurie turi bent viena "a" arba "A" raide.
        List<String> wordHavingLetterA =
                wordsList.stream()
                        .filter(word -> word.contains("a") || word.contains("A"))
                        .collect(Collectors.toList());
        System.out.println("1. Words have \"A\" or \"a\" = " + wordHavingLetterA);

//        2. suskaiciuoti kiek stringu yra ilgesni uz 6;
        int countWordsHaveLengthBiggestThatSix =
                (int) wordsList.stream()
                        .filter(word -> word.length() > 6)
                        .count();
        System.out.println("2. countWordsHaveLengthBiggestThatSix = " + countWordsHaveLengthBiggestThatSix);

//        3. surusiuoti sarasa atvirkstine abeceles tvarka;
        System.out.println("3. ------SORT------");
        wordsList
                .stream()
                .sorted(Comparator.comparing(String::toString))
                .forEach(word -> System.out.println(word));
        System.out.println("------/SORT------");

//        4. suskaiciuoti, kiek yra unikaliu stringu sarase;
        int countUnicWords = (int) wordsList
                .stream()
                .distinct()
                .count();
        System.out.println("4. Unic words = " + countUnicWords);

//        5. atrinkti stringus, kurie prasideda raide "s"
        long wordWithFirstSLetter = wordsList
                .stream()
                .filter(word -> word.startsWith("s"))
                .count();
        System.out.println("5. Word have start \"s\" = " + wordWithFirstSLetter);

//        6. is stringo paimti pirmus 2 simbolius ir suformuoti nauja sarasa
        List<String> firstTwoSymbols = wordsList
                .stream()
                .map(word -> word.substring(0,2))
                .collect(Collectors.toList());

        System.out.println("6. New list with first two symbols = " + firstTwoSymbols);
//
//        7. is saraso paversti integer sarasu, kuris turetu string ilgius
//        (pvz sarasas ["HAHA", "PIRMAS", "SEPTYNI"] turetu grazinti [4,6,7]
        List<Integer> wordsLength = wordsList
                .stream()
                .map(word -> word.length())
                .collect(Collectors.toList());

        System.out.println("7. new List with wordl length = " + wordsLength);

//        8. patikrinti, ar visi saraso elementai yra bent jau 3 simboliu ilgio
        boolean doesAllWordsLengthBiggestThatThree = wordsList
                .stream()
                .allMatch(word -> word.length() > 3);

        System.out.println("8. Does all words length biggest that three? " + doesAllWordsLengthBiggestThatThree);


    }
}
