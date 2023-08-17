package step.learning.eventone;

import java.util.Random;
import java.util.Scanner;
public class TicTacToe {
    private final Random random = new Random();
    private final char gamerX = 'X';
    private final char gamerO = 'O';
    boolean playerOne = true;
    boolean playerTwo = false;
    boolean gameOver = false;
    public void main() {
        int size = 3;
        boolean exit = true;
        char[][] map = new char[size][size];
        addMap(map);
        Scanner kbScanner = new Scanner( System.in );
        char ex;
        char currentGamer;
        printMap(map);
        do {
            if (playerOne) currentGamer = '1';
            else currentGamer = '2';
            System.out.print("Гравець " + currentGamer + " введіть координату стовпчика А-С = ");
            char xChar = kbScanner.next().charAt(0);
            xChar = Character.toUpperCase(xChar);
            System.out.print("Гравець " + currentGamer + " введіть координату рядка 1-3 = ");
            char yChar = kbScanner.next().charAt(0);
            int y = 10;
            int x = 10;
            switch (xChar) {
                case 'A': x = 0; break;
                case 'B': x = 1; break;
                case 'C': x = 2; break;
                default: break;
            }
            switch (yChar) {
                case '1': y = 0; break;
                case '2': y = 1; break;
                case '3': y = 2; break;
                default: break;
            }
            if (x == 10 || y == 10) {
                System.out.println(ConsoleColors.RED + "Гравець " + currentGamer + ", Ви ввели неіснуючі координати. Спробуйте ще раз." + ConsoleColors.RESET);
                continue;
            }
            if (map[y][x] == ' ' && playerOne) {
                map[y][x] = gamerX;
                playerOne = false;
                playerTwo = true;
            }
            else if (map[y][x] == ' ' && playerTwo) {
                map[y][x] = gamerO;
                playerOne = true;
                playerTwo = false;
            }
            else {
                System.out.println(ConsoleColors.RED + "Гравець " + currentGamer + " комірка зайнята. Вибіріть іншу." + ConsoleColors.RESET);
                continue;
            }
            gameOver = winCheck(map, (currentGamer == '1' ? gamerX : gamerO));
            printMap(map);
        } while(!gameOver);
        System.out.println(ConsoleColors.GREEN + "Гра закынчена. Гравець " + currentGamer + " переміг!" + ConsoleColors.RESET);
    }

    private void addMap(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = ' ';
            }
        }
    }
    private void printMap(char[][] arr) {
        System.out.println("  A B C");
        for (int i = 0; i < arr.length; i++) {
            System.out.print( (i + 1) + " ");
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 'X') {
                    System.out.print(ConsoleColors.BLUE + arr[i][j] + " " + ConsoleColors.RESET);
                }
                else if (arr[i][j] == 'O') {
                    System.out.print(ConsoleColors.YELLOW + arr[i][j] + " " + ConsoleColors.RESET);
                }
                else System.out.print(arr[i][j] + " " );
            }
            System.out.println();
        }
    }
    private boolean winCheck(char[][] arr, char gamer) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[0][i] == gamer && arr[1][i] == gamer && arr[2][i] == gamer)
                return true;
            if (arr[i][0] == gamer && arr[i][1] == gamer && arr[i][2] == gamer)
                return true;
        }
        if (arr[0][0] == gamer && arr[1][1] == gamer && arr[2][2] == gamer)
            return true;
        if (arr[0][2] == gamer && arr[1][1] == gamer && arr[2][0] == gamer)
            return true;
        return false;
    }

}
