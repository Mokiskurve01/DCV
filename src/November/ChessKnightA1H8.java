package November;

import java.util.Random;

/***
 * 1#Schachbrett mit Zahlen und Buchstaben
 * 2#Startposition Pferd A1
 * 3#Zufall Zug vom Pferd(8 möglichkeiten)
 * 4#Prüfen ob das Pferd auf dem Schachbrett bleibt
 * 5#Ende wenn das Pferd H8 erreicht
 */

public class ChessKnightA1H8 {
    public static void main(String[] args) {
        int posB = 0;
        int posZ = 7;
        int zaehler = 0;
        printSchachbrett(posB, posZ);
        sprung(posB, posZ, zaehler);
    }

    private static void sprung(int posB, int posZ, int zaehler) {
        do {
            zaehler++;
            try { Thread.sleep(10); } catch (InterruptedException ie) { /* Ignore */ };
            int[] zufall = {0, 1, 2, 3, 4, 5, 6, 7};
            Random zufallpos = new Random();
            int jump = zufallpos.nextInt(zufall.length);
            int tempB = posB;
            int tempZ = posZ;

            switch (jump) {
                case 0: posB += 2;posZ += 1;break;
                case 1: posB += 2;posZ -= 1;break;
                case 2: posB -= 2;posZ += 1;break;
                case 3: posB -= 2;posZ -= 1;break;
                case 4: posB += 1;posZ += 2;break;
                case 5: posB += 1;posZ -= 2;break;
                case 6: posB -= 1;posZ += 2;break;
                case 7: posB -= 1;posZ -= 2;break;
            }
            if (posB < 0 || posB > 7 || posZ < 0 || posZ > 7) {
                posB = tempB;
                posZ = tempZ;
            } else {
                printSchachbrett(posB, posZ);
            }
        } while (posB != 7 || posZ != 0);
        System.out.println("Ziel erreicht! Es braucht "+zaehler+" Zufallzüge von A1 bis H8!");
    }

    private static void printSchachbrett(int posB, int posZ) {
        int[] knightPos = {posB, posZ};
        String[][] schachbrett = new String[8][8];
        int[] zahlen = {1, 2, 3, 4, 5, 6, 7, 8};
        String[] buchstaben = {" ", " A", " B", " C", " D", " E", " F", " G", " H",};
        for (
                int i = 0;
                i <= schachbrett.length; i++) {
            System.out.print(buchstaben[i]);
        }
        System.out.println();
        for (int i = 0; i < schachbrett.length; i++) {
            System.out.print(zahlen[schachbrett.length - 1 - i]);
            for (int j = 0; j < schachbrett.length; j++) {
                if ((j == knightPos[0]) && (i == knightPos[1])) System.out.print(" K");
                else System.out.print(" _");
            }
            System.out.println();
        }
    }
}

