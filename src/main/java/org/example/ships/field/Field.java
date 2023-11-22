package org.example.ships.field;

import org.example.ships.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Field {
    private final static Scanner scanner = new Scanner(System.in);
    private final Cell[][] militaryField = new Cell[12][12];//создание масива с большими размерами для удобства
    private final List<Ship> listShip = new ArrayList<>();
    public int shipsHp = 17;
    public Field() {
        listShip.add(new AircraftCarrier());
        listShip.add(new Battleship());
        listShip.add(new Submarine());
        listShip.add(new Cruiser());
        listShip.add(new Destroyer());
        createField();
    }

    public int getShipsHp() {
        return shipsHp;
    }


    public void gameStart() {

        ShotResult shoot;
        while (true) {
            String input = scanner.nextLine();
            try {
                ShotCoordinate shotCoordinate = new ShotCoordinate(input);
                shoot = militaryField[shotCoordinate.getX1()][shotCoordinate.getY1()].shoot();
                System.out.println(shoot.getShotResult());
                if (shoot != ShotResult.MIS){
                    shipsHp--;
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //создание нового коробля с определённым размером
    public void spawnShips() {

        listShip.forEach(ship -> {
            System.out.println();
            System.out.printf("Enter the coordinates of the %s (%d cell):%n", ship.getName(), ship.getSize());
            while (true) {
                LengthCoordinate coordinate;
                try {
                    String input = scanner.nextLine();
                    coordinate = new LengthCoordinate(input);

                    if (coordinate.getLength() != ship.getSize()) {
                        throw new IllegalStateException("Error! Wrong length of the Submarine! Try again:");
                    }

                    for (int i = coordinate.getX1() - 1; i <= coordinate.getX2() + 1; i++) {
                        for (int j = coordinate.getY1() - 1; j <= coordinate.getY2() + 1; j++) {
                            if (militaryField[i][j] instanceof Ship) {
                                throw new IllegalStateException("Error! You placed it too close to another one. Try again:");
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                List<LengthCoordinate.SimpleCoordinate> list = coordinate.asSimpleCoordinates();
                for (LengthCoordinate.SimpleCoordinate s : list) {
                    militaryField[s.getX()][s.getY()] = ship.getInstance();
                }
                break;
            }

            display();
        });
    }


    //заполнение поля бланком и рамками
    public void createField() {
        for (int i = 0; i < militaryField.length; i++) {
            for (int j = 0; j < militaryField.length; j++) {
                if (i == 0 || i == militaryField.length - 1 || j == 0 || j == militaryField.length - 1) {
                    militaryField[i][j] = new Frames();
                } else {
                    militaryField[i][j] = new Blank();
                }
            }
        }
    }


    //вывод на дисплэй игрового поля
    public void display() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 1; i < militaryField.length - 1; i++) {
            System.out.print((char) ('A' + i - 1) + " ");
            for (int j = 1; j < militaryField.length - 1; j++) {
                System.out.print(militaryField[i][j] + " ");
            }
            System.out.println();
        }
    }

    //выыводит на дисплей только корабли

    public void display2() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 1; i < militaryField.length - 1; i++) {
            System.out.print((char) ('A' + i - 1) + " ");
            for (int j = 1; j < militaryField.length - 1; j++) {
                System.out.print(militaryField[i][j].specialToString() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void fogOfWar() {
        Arrays.stream(militaryField)
                .flatMap(Arrays::stream)
                .forEach(Cell::hide);
    }
}