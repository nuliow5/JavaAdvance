package eu.codeacademy.taskGame.player;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BasketballPlayer extends Player{
    private double height;
    public BasketballPlayer(String name, Integer number, double height) {
        super(name, number);
        this.height = height;
    }
}
