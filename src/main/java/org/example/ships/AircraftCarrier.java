package org.example.ships;


import org.example.ships.field.Ship;

public class AircraftCarrier extends Ship {
    static int hp = 5;

    public AircraftCarrier() {
        super(hp);
    }

    @Override
    public int minusHp() {
        return --hp;
    }

    @Override
    public String getName() {
        return "Aircraft Carrier";
    }

    @Override
    public Ship getInstance() {
        return new AircraftCarrier();
    }
}
