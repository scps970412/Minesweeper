package codejava;

import java.util.Scanner;

public class Minesweeper {
    static int size;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = Integer.parseInt(sc.nextLine());
        map = new int[size][size];
        sc = new Scanner(System.in);
        int qty = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < qty; i++) {
            sc = new Scanner(System.in);
            String[] xy = sc.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            map[x][y] = 9;
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
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void addMark(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size && map[x][y] != 9) {
            map[x][y]++;
        }
    }
}
