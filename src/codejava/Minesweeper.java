package codejava;

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
                map[i][j].printCode();
            }
            System.out.println();
        }
    }

    private static void initMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = State.zero;
            }
        }
    }

    private static void addMark(int x, int y) {
        if (x >= 0 && x < size && y >= 0 && y < size && map[x][y] != State.mines) {
            switch (map[x][y]) {
            case zero:
                map[x][y] = State.one;
                break;
            case one:
                map[x][y] = State.two;
                break;
            case two:
                map[x][y] = State.three;
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
        zero {
            public void printCode() {
                System.out.print(0);
            }
        },
        one {
            public void printCode() {
                System.out.print(1);
            }
        },
        two {
            public void printCode() {
                System.out.print(2);
            }
        },
        three {
            public void printCode() {
                System.out.print(3);
            }
        },
        four {
            public void printCode() {
                System.out.print(4);
            }
        },
        five {
            public void printCode() {
                System.out.print(5);
            }
        },
        six {
            public void printCode() {
                System.out.print(6);
            }
        },
        seven {
            public void printCode() {
                System.out.print(7);
            }
        },
        eight {
            public void printCode() {
                System.out.print(8);
            }
        },
        mines {
            public void printCode() {
                System.out.print(9);
            }
        };

        public abstract void printCode();

    }
}
