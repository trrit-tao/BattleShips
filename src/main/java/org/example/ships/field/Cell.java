package org.example.ships.field;

public class Cell {
    final String publicMeaning;
    final String privateMeaning;
    String fieldPlayer;
    String fogOfWar = "~";


    public Cell(String meaning, String publicMeaning) {
        this.privateMeaning = meaning;
        this.publicMeaning = publicMeaning;
        this.fieldPlayer = publicMeaning;
    }


    public void hide() {
        fieldPlayer = fogOfWar;
    }

    public String specialToString() {
        return toString();
    }


    public ShotResult shoot() {
        fieldPlayer = privateMeaning;
        return ShotResult.MIS;
    }


    public boolean alreadyShoot() {
        return fieldPlayer.equals(privateMeaning);
    }


    @Override
    public String toString() {
        return fieldPlayer;
    }
}

