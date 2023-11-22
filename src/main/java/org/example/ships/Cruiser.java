package org.example.ships;

import org.example.ships.field.Ship;

public class Cruiser extends Ship {
    static int hp = 3;

    public Cruiser() {
        super(hp);
    }

    @Override
    public int minusHp() {
        return --hp;
    }

    @Override
    public String getName() {
        return "Cruiser";
    }

    @Override
    public Ship getInstance() {
        return new Cruiser();
    }
}
