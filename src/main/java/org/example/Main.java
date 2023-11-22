package org.example;



import org.example.ships.field.Field;

import java.util.Scanner;

public class Main {

    static Scanner sr = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Field field = new Field();
        System.out.println("Player 1, place your ships on the game field\n");
        field.display();
        field.spawnShips();
        field.fogOfWar();
        Field field2 = new Field();
        System.out.println("Press Enter and pass the move to another player\n");
        sr.nextLine();
        System.out.println("Player 2, place your ships to the game field\n");
        field2.display();
        field2.spawnShips();
        field2.fogOfWar();
        while (true) {
            //ход первого игрока
            System.out.println("Press Enter and pass the move to another player\n");
            sr.nextLine();
            field2.display();
            System.out.println("---------------------");
            field.display2();
            System.out.println("Player 1, it's your turn:\n");
            field2.gameStart();
            //проверка на победу
            if (field2.getShipsHp() == 0) {

                break;
            }
            //ход второго игрока
            System.out.println("Press Enter and pass the move to another player\n");
            sr.nextLine();
            field.display();
            System.out.println("---------------------");
            field2.display2();
            System.out.println("Player 2, it's your turn:\n");
            field.gameStart();
            //проверка на победу
            if (field.getShipsHp() == 0) {
                break;
            }
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }
}