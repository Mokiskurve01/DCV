import java.util.Scanner;

/***
 * Schreibe ein Programm welches eine Zufallszahl zwischen 1 und 50 generiert. Der Benutzer
 * darf 10 mal versuchen diese Zahl einzutippen und wir verraten ihm, ob er höher oder
 * niedriger tippen muss.
 * Ist die Zahl erraten, so ist das Spiel gewonnen.
 */

public class ZufallszahlErraten {
    public static void main(String[] args) {
        Scanner scanZahl = new Scanner(System.in);
        int zufallzahl = (int) (1 + (Math.random()) * 49);
        int versuche = 10;
        for (int i = 0; i < versuche; i++) {
            System.out.println("Geben Sie bitte eine Zahl zwischen 1 und 50 ein." +
                    " Sie haben noch:" + ((versuche) - i) + " Versuche.");
            int zahl = scanZahl.nextInt();
            if (zahl > 50 || zahl < 1) {
                System.err.println("Ihre Zahl liegt nicht zwischen 1 und 50!!!");
            } else if (zufallzahl == zahl) {
                System.out.println("Gratulation Sie haben die richtige Zahl erraten!!!");
                break;
            } else if (zufallzahl < zahl) {
                System.out.println("Die zufall Zahl ist kleiner.");
            } else if (zufallzahl > zahl) {
                System.out.println("Die zufall Zahl ist größer.");
            } else {
                System.out.println("!!!!Game over!!!!");
            }
        }
    }
}
