package org.example.ships.field;

public enum ShotResult {
    MIS("You missed!"),

    HIT("You hit a ship!"),

    RIP("You sank a ship!");

    final String shotResult;

    ShotResult(String s) {
        shotResult = s;
    }

    public String getShotResult() {
        return shotResult;
    }
}

