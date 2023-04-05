package eu.codeacademy.taskGame.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Player {
    private String name;
    private Integer number;

    public Player(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Long countUnicPlayers(List<BasketballPlayer> firstList, List<BasketballPlayer> secondList) {
        List<BasketballPlayer> mixList = new ArrayList<>();
        mixList.addAll(firstList);
        mixList.addAll(secondList);

        Long countUnicPlayer =
                mixList.stream()
                        .distinct()
                        .count();

        return countUnicPlayer;
    }

    public static Long uniquePlayersCount(List<Player> firstList, List<Player> secondList) {
        Long countUnicPlayer =
                Stream.of(firstList, secondList)
                        .flatMap(List::stream)
                        .distinct()
                        .count();

        return countUnicPlayer;
    }


}
