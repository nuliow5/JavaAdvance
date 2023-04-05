package eu.codeacademy.taskGame.player;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FootballPlayer extends Player{
    private double legLength;

    public FootballPlayer(String name, Integer number, double legLength) {
        super(name, number);
        this.legLength = legLength;
    }
}
