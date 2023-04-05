package eu.codeacademy.taskGame.team;

import eu.codeacademy.taskGame.player.BasketballPlayer;
import eu.codeacademy.taskGame.player.Player;
import org.jetbrains.annotations.NotNull;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Team<T extends Player> implements Comparable<Team> {
    private String name;
    private int won;
    private List<T> players;

    public Team() {

    }

    public Team(String name) {
        this.name = name;
        this.won = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWon() {
        System.out.println(getName() + ": " + this.won);
        return won;
    }

    public void setWon(int won) {
        this.won = won;

    }

    public List<T> getPlayers() {
        return players;
    }

    public void setPlayers(List<T> players) {
        this.players = players;
    }

    public boolean addPlayer(T player) {
        players.add(player);
        return true;
    }


    public void playMatch(Team<T> team, int ourScore, int enemyScore) {
        if (ourScore > enemyScore) {
            this.won++;
        } else {
            team.won++;
        }
    }


    @Override
    public int compareTo(@NotNull Team o) {
        return o.getWon() - this.getWon();
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

    public Long countUnicPlayersAnotherMethod(List<BasketballPlayer> firstList, List<BasketballPlayer> secondList) {


        Long countUnicPlayer =
                Stream.of(firstList, secondList)
                        .flatMap(List::stream)
                        .distinct()
                        .count();


        return countUnicPlayer;
    }


}
