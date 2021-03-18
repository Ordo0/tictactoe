package tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] table = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = ' ';
            }
        }
        printTable(table);

        System.out.println("Enter the coordinates:");

        Scanner str = new Scanner(System.in);
        while (true) {
            if (!str.hasNextInt()) {
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates:");
                str.next();
            } else {
                int x = str.nextInt();
                int y = str.nextInt();
                if (!(x >= 1 && x <= 3 && y >= 1 && y <= 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates:");
                } else if ((table[x - 1][y - 1] != ' ')) {
                    System.out.println("This cell is occupied! Choose another one!\nEnter the coordinates:");
                } else {
                    table[x - 1][y - 1] = 'X';
                    printTable(table);
                }
            }
            if (isWin(table, 'X')) {
                System.out.println("X wins");
                break;
            }
            if (isFull(table)) {
                System.out.println("Draw");
                break;
            }
            if (!str.hasNextInt()) {
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates:");
                str.next();
            } else {
                int x = str.nextInt();
                int y = str.nextInt();
                if (!(x >= 1 && x <= 3 && y >= 1 && y <= 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Enter the coordinates:");
                } else if ((table[x - 1][y - 1] != ' ')) {
                    System.out.println("This cell is occupied! Choose another one!\nEnter the coordinates:");
                } else {
                    table[x - 1][y - 1] = 'O';
                    printTable(table);
                }
            }
            if (isWin(table, 'O')) {
                System.out.println("O wins");
                break;
            }
            if (isFull(table)) {
                System.out.println("Draw");
                break;
            }
        }
    }
    static void printTable(char[][] table) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
        }
        System.out.print("|");
        System.out.println();
    }
        System.out.println("---------");
    }

    static boolean isWin(char[][] table, char xo) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == xo && table[i][1] == xo &&
                    table[i][2] == xo) ||
                    (table[0][i] == xo && table[1][i] == xo &&
                            table[2][i] == xo))
                return true;
        if ((table[0][0] == xo && table[1][1] == xo &&
                table[2][2] == xo) ||
                (table[2][0] == xo && table[1][1] == xo &&
                        table[0][2] == xo))
            return true;
        return false;
    }
    static boolean isFull(char[][] table) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (table[i][j] == ' ')
                    return false;
        return true;
    }
}