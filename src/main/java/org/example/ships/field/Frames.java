package org.example.ships.field;

public class Frames extends Cell {

    public Frames() {
        super("M", "~");
    }


    @Override
    public boolean alreadyShoot() {
        return true;
    }
}
