package November;

import java.util.Random;

/***
 * 1#Schachbrett mit Zahlen und Buchstaben.                                     (String [19][19])
 * 2#Startposition KW(Knight weiß) auf A1 und KS(Knight schwarz) auf H8.        (int [2],int posB,int posZ)
 * 3#Knights abwechslungsweise einen Zug machen.                                (boolean weiß)
 * 4#Zufall Zug vom Knight(8 möglichkeiten).                                    (int [8], Random zufallzahl, int jump,)
 * 5#Prüfen ob das Pferd auf dem Schachbrett bleibt.                            if(<>)
 * 6#Ende wenn die Pferde sich treffen,                                          if(posKW==posKS)
 * 7#Welches Pferd hat das andere geschlagen?
 */

public class ChessTwoKnight2 {
    public static void main(String[] args) {
        String[][] spielfeld = {
                {"     ", ",", "  A  ", ",", "  B  ", ",", "  C  ", ",", "  D  ", ",", "  E  ", ",", "  F  ", ",", "  G  ", ",", "  H  ", ",", "     "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  8  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  8  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  7  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  7  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  6  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  6  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  5  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  5  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  4  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  4  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  3  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  3  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  2  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  2  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  1  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  1  "},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"     ", "'", "  A  ", "'", "  B  ", "'", "  C  ", "'", "  D  ", "'", "  E  ", "'", "  F  ", "'", "  G  ", "'", "  H  ", "'", "     "},
        };
        int posBW = 16;
        int posZW = 2;
        int posBS = 2;
        int posZS = 16;
        String knightW = " KW  ";
        String leer = "     ";
        String knightS = " KS  ";
        int[] knightWPos = {posBW, posZW};
        int[] knightSPos = {posBS, posZS};
        spielfeld[knightWPos[0]][knightWPos[1]] = knightW;
        spielfeld[knightSPos[0]][knightSPos[1]] = knightS;
        printSchachbrett(spielfeld);
        boolean weiß = true;
        boolean terffer = false;
        while (!terffer) {
            Random zufallpos = new Random();
            boolean erlaubterZug = false;
         //   boolean erlaubterZugS = false;
            int posB = 0;
            int posZ = 0;
            while (!erlaubterZug) {
                int jump = zufallpos.nextInt(8);
                switch (jump) {
                    case 0:
                        posB = 4;
                        posZ = 2;
                        break;
                    case 1:
                        posB = 4;
                        posZ = -2;
                        break;
                    case 2:
                        posB = -4;
                        posZ = 2;
                        break;
                    case 3:
                        posB = -4;
                        posZ = -2;
                        break;
                    case 4:
                        posB = 2;
                        posZ = 4;
                        break;
                    case 5:
                        posB = 2;
                        posZ = -4;
                        break;
                    case 6:
                        posB = -2;
                        posZ = 4;
                        break;
                    case 7:
                        posB = -2;
                        posZ = -4;
                        break;
                }
              //  System.out.println(jump);
              //  System.out.println(posB);
              //  System.out.println(posZ);
                erlaubterZug = istErlaubterZugW(knightWPos, posB, posZ)&&istErlaubterZugW(knightWPos, posB, posZ);
               // erlaubterZugS = istErlaubterZugS(knightSPos, posB, posZ);
            }
            if (weiß) {
                spielfeld[knightWPos[0]][knightWPos[1]] = leer;
                knightWPos[0] += posB;
                knightWPos[1] += posZ;
                spielfeld[knightWPos[0]][knightWPos[1]] = knightW;
                printSchachbrett(spielfeld);
            } else {
                spielfeld[knightSPos[0]][knightSPos[1]] = leer;
                knightSPos[0] += posB;
                knightSPos[1] += posZ;
                spielfeld[knightSPos[0]][knightSPos[1]] = knightS;
                printSchachbrett(spielfeld);
            }
            weiß = weiß;
            terffer = isTreffer(knightWPos, knightSPos);
        }
    }

    private static boolean isTreffer(int[] knightWPos, int[] knightSPos) {
        return knightWPos[0] == knightSPos[0] && knightWPos[1] == knightSPos[1];
    }

    private static boolean istErlaubterZugS(int[] knightSPos, int posB, int posZ) {
        return knightSPos[0] + posB >= 2 && knightSPos[0] + posB <= 16 && knightSPos[1] + posZ >= 2 && knightSPos[1] + posZ <= 16;
    }

    private static boolean istErlaubterZugW(int[] knightWPos, int posB, int posZ) {
        return knightWPos[0] + posB >= 2 && knightWPos[0] + posB <= 16 && knightWPos[1] + posZ >= 2 && knightWPos[1] + posZ <= 16;
    }

    private static void printSchachbrett(String[][] spielfeld) {
        for (String[] reihe : spielfeld) {
            for (String aString : reihe) {
                System.out.print(aString);
            }
            System.out.println();
        }
        System.out.println("===========================================================");
    }
}
