package org.example.ships;

import org.example.ships.field.Ship;

public class Battleship extends Ship {
    static int hp = 4;

    public Battleship() {
        super(hp);
    }

    @Override
    public int minusHp() {
        return --hp;
    }

    @Override
    public String getName() {
        return "Battleship";
    }

    @Override
    public Ship getInstance() {
        return new Battleship();
    }
}
