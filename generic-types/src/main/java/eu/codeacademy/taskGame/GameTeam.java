package eu.codeacademy.taskGame;

import eu.codeacademy.taskGame.player.BasketballPlayer;
import eu.codeacademy.taskGame.player.FootballPlayer;
import eu.codeacademy.taskGame.team.Team;

import java.util.ArrayList;
import java.util.List;

public class GameTeam {
    public static void main(String[] args) {
        BasketballPlayer sabonis = new BasketballPlayer("Sabonis", 11, 220.20);
        BasketballPlayer jasikavicius = new BasketballPlayer("Jasikevicius", 13, 195.30);

        BasketballPlayer gustas = new BasketballPlayer("Gustas", 7, 195.30);
        BasketballPlayer sestokas = new BasketballPlayer("Sestokas", 6, 195.30);


        List<BasketballPlayer> zalgirisList = new ArrayList<>();

        Team<BasketballPlayer> zalgiris = new Team<>("Zalgiris");

        zalgirisList.add(sabonis);
        zalgirisList.add(jasikavicius);

        List<BasketballPlayer> rytasList = new ArrayList<>();
        Team<BasketballPlayer> rytas = new Team<>("Rytas");

        rytasList.add(gustas);
        rytasList.add(sestokas);
        rytasList.add(sabonis);

        zalgiris.playMatch(rytas, 98, 95);
        zalgiris.getWon();
        rytas.getWon();



//        FOOTBALL

        FootballPlayer ronaldo = new FootballPlayer("Ronaldo",7, 3.5);
        FootballPlayer messi = new FootballPlayer("Messi",10, 3.7);

        System.out.println("EQUALS " + ronaldo.equals(ronaldo));
        System.out.println("===== " + (ronaldo==ronaldo));

        List<FootballPlayer> realMadridList = new ArrayList<>();
        realMadridList.add(ronaldo);
        realMadridList.add(messi);

        Team<FootballPlayer> realMadrid = new Team<>("Real Madrid");
        Team<FootballPlayer> barcelona = new Team<>("Barcelona");

        realMadrid.playMatch(barcelona, 3, 2);
        realMadrid.getWon();
        barcelona.getWon();
        realMadrid.playMatch(barcelona, 3, 2);
        realMadrid.getWon();
        barcelona.getWon();


//        realMadrid.playMatch(zalgiris, 35, 15);
        System.out.println("count------");
        System.out.println(new Team<>().countUnicPlayers(rytasList, zalgirisList));

        System.out.println("count------another method");
        System.out.println(new Team<>().countUnicPlayersAnotherMethod(rytasList, zalgirisList));





    }
}
