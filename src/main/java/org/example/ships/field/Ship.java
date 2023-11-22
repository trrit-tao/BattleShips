package org.example.ships.field;

public abstract class Ship extends Cell {
    private final int size;

    public
    Ship(int size) {
        super("X", "O");
        this.size = size;
    }

    public abstract int minusHp();

    public int getSize() {
        return size;
    }

    public abstract String getName();

    public abstract Ship getInstance();

    @Override
    public ShotResult shoot() {
        if (alreadyShoot()) {
            return ShotResult.MIS;
        }
        fieldPlayer = privateMeaning;
        if (minusHp() == 0) {
            return ShotResult.RIP;
        }
        return ShotResult.HIT;
    }

    @Override
    public String specialToString() {
        return alreadyShoot()
                ? privateMeaning
                : publicMeaning;
    }
}