package November;

import java.util.Scanner;

public class TicTacTo {
    public static void main(String[] args) {
        char[][] spielfeld = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},};
        printSpielfeld(spielfeld);
        Scanner scanPos = new Scanner(System.in);
        System.out.println("Geben Sie bitte ihre Position ein.(1-9)");
        int pos = scanPos.nextInt();
        wahlDerPosPlay(spielfeld,pos,"player1");
        printSpielfeld(spielfeld);
    }
    public static void printSpielfeld(char[][] spielfeld) {
        for (char[] reihe : spielfeld) {
            for (char spalte : reihe) {
                System.out.print(spalte);
            }
            System.out.println();
        }
    }
    public static void wahlDerPosPlay(char[][] spielfeld,int pos, String user){
        char symbol;


        symbol='O';
        switch (pos) {
            case 1 -> spielfeld[0][0] = symbol;
            case 2 -> spielfeld[0][2] = symbol;
            case 3 -> spielfeld[0][4] = symbol;
            case 4 -> spielfeld[2][0] = symbol;
            case 5 -> spielfeld[2][2] = symbol;
            case 6 -> spielfeld[2][4] = symbol;
            case 7 -> spielfeld[4][0] = symbol;
            case 8 -> spielfeld[4][2] = symbol;
            case 9 -> spielfeld[4][4] = symbol;
        }
    }
}

