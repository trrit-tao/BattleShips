package org.example.ships.field;

import java.util.ArrayList;
import java.util.List;

public class LengthCoordinate {
    private final int x1;//введённая координата буква
    private final int y1;//введённая координата цифра
    private final int x2;//введённая координата буква
    private final int y2;//введённая координата цифра
    private final int length;//длинна расстояния между координат


    public LengthCoordinate(String str) throws Exception {
        String[] result = str.split(" ");//разделяет ввод на две ячейки массива
        int[] x1y1 = build(result[0]);//первая ячейка массива
        int[] x2y2 = build(result[1]);//вторая ячейка массива
        this.x1 = Math.min(x1y1[0], x2y2[0]);//выявляем мин значение
        this.x2 = Math.max(x2y2[0], x1y1[0]);//выявляем макс значение
        this.y1 = Math.min(x1y1[1], x2y2[1]);//выявляем мин значение
        this.y2 = Math.max(x2y2[1], x1y1[1]);//выявляем макс значение

        if (!(x1 == x2 || y1 == y2)) {  //проверка образуют линию
            throw new IllegalStateException("Error! Wrong ship location! Try again:");
        }
        if (x1 == x2) {
            this.length = Math.abs(y1 - y2) + 1; //возвращает положительное значение
        } else {
            this.length = Math.abs(x1 - x2) + 1;//возвращает положительное значение
        }
    }


    //возващает координаты между вводом
    public List<SimpleCoordinate> asSimpleCoordinates() {
        List<SimpleCoordinate> list = new ArrayList<>();
        if (x1 == x2) {
            for (int i = 0; i < length; i++) {
                list.add(new SimpleCoordinate(x1, y1 + i));
            }
        }
        if (y1 == y2) {
            for (int i = 0; i < length; i++) {
                list.add(new SimpleCoordinate(x1 + i, y1));
            }
        }
        return list;
    }


    //получаем коодинаты ячеек коробля
    public int getLength() {
        return length;
    }


    //конвектируем ввод в инт для удобства работы
    private int[] build(String str) {
        int a1 = str.charAt(0) - 'A';
        String b1 = str.substring(1);
        int s1 = Integer.parseInt(b1) - 1;

        if (!((a1 >= 0 && a1 <= 9) && (s1 >= 0 && s1 <= 9))) {
            throw new IllegalStateException("Error! You entered the wrong coordinates! Try again:");
        }
        return new int[]{a1 + 1, s1 + 1};
    }


    //пулучить координату
    public int getX1() {
        return x1;
    }


    //пулучить координату
    public int getY1() {
        return y1;
    }


    //пулучить координату
    public int getX2() {
        return x2;
    }


    //пулучить координату
    public int getY2() {
        return y2;
    }


    public static class SimpleCoordinate {
        private final int x;
        private final int y;

        private SimpleCoordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}