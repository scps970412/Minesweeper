package codejava;

import java.io.ObjectInputFilter.Status;
import java.util.Scanner;

public class Minesweeper {
    static int size;
    static State[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = Integer.parseInt(sc.nextLine());
        map = new State[size][size];
        initMap();

        sc = new Scanner(System.in);
        int qty = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < qty; i++) {
            sc = new Scanner(System.in);
            String[] xy = sc.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            map[x][y] = State.mines;
            addMark(x - 1, y - 1);
            addMark(x - 1, y);
            addMark(x - 1, y + 1);
            addMark(x, y - 1);
            addMark(x, y + 1);
            addMark(x + 1, y - 1);
            addMark(x + 1, y);
            addMark(x + 1, y + 1);
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                switch (map[i][j]) {
                case initial:
                    System.out.print(0);
                    break;
                case one:
                    System.out.print(1);
                    break;
                case two:
                    System.out.print(2);
                    break;
                case three:
                    System.out.print(3);
                    break;
                case four:
                    System.out.print(4);
                    break;
                case five:
                    System.out.print(5);
                    break;
                case six:
                    System.out.print(6);
                    break;
                case seven:
                    System.out.print(7);
                    break;
                case eight:
                    System.out.print(8);
                    break;
                case mines:
                    System.out.print(9);
                    break;
                }
            }
            System.out.println();
        }
    }

    private static void initMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = State.initial;
            }
        }
    }

    private static void addMark(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size && map[x][y] != State.mines) {
            switch (map[x][y]) {
            case initial:
                map[x][y] = State.one;
                break;
            case one:
                map[x][y] = State.two;
                break;
            case two:
                map[x][y] = State.three;
                break;
            case three:
                map[x][y] = State.four;
                break;
            case four:
                map[x][y] = State.five;
                break;
            case five:
                map[x][y] = State.six;
                break;
            case six:
                map[x][y] = State.seven;
                break;
            case seven:
                map[x][y] = State.eight;
                break;
            }
        }
    }

    enum State {
        initial, one, two, three, four, five, six, seven, eight, mines
    };
}
