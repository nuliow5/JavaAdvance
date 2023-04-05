package eu.codeacademy.taskGame;

import eu.codeacademy.taskGame.player.BasketballPlayer;

import eu.codeacademy.taskGame.player.Player;
import eu.codeacademy.taskGame.team.Team;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTeamTest {

    Team<BasketballPlayer> zalgiris;
    Team<BasketballPlayer> rytas;
    Team<BasketballPlayer> wolves;


    @BeforeEach
    void setUp() {
        zalgiris = new Team<>("Zalgiris");
        rytas = new Team<>("Rytas");
        wolves = new Team<>("Wolf");
    }

    @Test
    void playMatchTest() {

        zalgiris.playMatch(rytas, 85,82);
        assertEquals(1, zalgiris.getWon());
    }

    @Test
    void playMatchTheyWinTest() {

        zalgiris.playMatch(rytas, 82,85);
        assertEquals(0, zalgiris.getWon());
        assertEquals(1, rytas.getWon());

    }

    @Test
    void sortByWinsDescendingTest() {

        zalgiris.setWon(10);
        rytas.setWon(5);
        wolves.setWon(6);
        List<Team> teams = new ArrayList<>(Arrays.asList(wolves, rytas, zalgiris));
        teams = teams.stream().sorted().collect(Collectors.toList());
        assertEquals(10, teams.get(0).getWon());
        assertEquals(6, teams.get(1).getWon());
        assertEquals(5, teams.get(2).getWon());

    }

    @Test
    void uniquePlayersCountTest() {

        List<Player> players = new ArrayList<>();
        List<Player> players2 = new ArrayList<>();
        Player sabonis = new Player("Arvydas",  11);
        Player jasikevicius = new Player("Sarunas",  13);
        Player macijauskas = new Player("Arvydas",  7);
        Player javtokas = new Player("Robertas",  15);

        players.add(sabonis);
        players.add(sabonis);
        players.add(jasikevicius);
        players.add(jasikevicius);

        players2.add(macijauskas);
        players2.add(macijauskas);
        players2.add(javtokas);
        players2.add(sabonis);
        players2.add(jasikevicius);

        Long uniquePlayers = Player.uniquePlayersCount(players, players2);
        assertEquals(4, uniquePlayers);

    }


}
