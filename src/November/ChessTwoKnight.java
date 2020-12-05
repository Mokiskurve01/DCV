package November;

import java.util.Random;

/***
 * 1#Schachbrett mit Zahlen und Buchstaben
 * 2#Startposition Pferd-schwarz A1 und Pferd-weiß H8
 * 3#Zufall Zug vom Pferd(8 möglichkeiten)
 * 4#Prüfen ob das Pferd auf dem Schachbrett bleibt
 * 5#Ende wenn die Pferde sich treffen
 */

public class ChessTwoKnight {
    public static void main(String[] args) {
        String[][] spielfeld = {
                {"     ", ",", "  A  ", ",", "  B  ", ",", "  C  ", ",", "  D  ", ",", "  E  ", ",", "  F  ", ",", "  G  ", ",", "  H  ", ",", "     ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  8  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  8  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  7  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  7  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  6  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  6  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  5  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  5  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  4  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  4  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  3  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  3  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  2  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  2  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"  1  ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "     ", "|", "  1  ",},
                {"    -", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-----", "+", "-    "},
                {"     ", "'", "  A  ", "'", "  B  ", "'", "  C  ", "'", "  D  ", "'", "  E  ", "'", "  F  ", "'", "  G  ", "'", "  H  ", "'", "     ",},

        };
        int posBW = 8;
        int posZW = 8;
     //   int posZS = 16;
     //   int posBS = 2;
       // int zaehler=0;
       // boolean weiß = true;
       // String leer = "     ";
        String knightW = " KW  ";
        String knightS = " KS  ";
        int[] knightWPos = {posBW, posZW};
        //int[] knightSPos = {posBS, posZS};
        spielfeld[knightWPos[0]][knightWPos[1]] = knightW;
        //spielfeld[knightSPos[0]][knightSPos[1]] = knightS;
        for (String[] reihe : spielfeld) {
            for (String aString : reihe) {
                System.out.print(aString);
            }
            System.out.println();
        }
        System.out.println("===========================================================");
        int i=0;
        do {
          //  zaehler++;
            try { Thread.sleep(500); } catch (InterruptedException ie) { /* Ignore */ };
            int[] zufall = {0, 1, 2, 3, 4, 5, 6, 7};
            Random zufallpos = new Random();
            int jump = zufallpos.nextInt(zufall.length);
            int tempB = posBW;
            int tempZ = posZW;
            switch (jump) {
                case 0: posBW += 2;posZW += 1;break;
                case 1: posBW += 2;posZW -= 1;break;
                case 2: posBW -= 2;posZW += 1;break;
                case 3: posBW -= 2;posZW -= 1;break;
                case 4: posBW += 1;posZW += 2;break;
                case 5: posBW += 1;posZW -= 2;break;
                case 6: posBW -= 1;posZW += 2;break;
                case 7: posBW -= 1;posZW -= 2;break;
            }
            if (posBW < 2 || posBW > 16 || posZW < 2 || posZW > 16) {
                posBW = tempB;
                posZW = tempZ;
            } else {
                knightWPos[0] = posBW;
                knightWPos[1] = posZW;
                for (String[] reihe : spielfeld) {
                    for (String aString : reihe) {
                        System.out.print(aString);
                    }
                    System.out.println();
                }
                System.out.println("===========================================================");

            }i++;
        } while (i<8);//!knightWPos.equals(knightSPos)
        //System.out.println("Ziel erreicht! Es braucht "+zaehler+" Züge bis ein Pferd das andere Schlägt!");

    }


}

