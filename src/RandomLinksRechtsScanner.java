import java.util.Random;
import java.util.Scanner;

public class RandomLinksRechtsScanner {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wie lange soll das Feld sein?");
        int laenge = Integer.MIN_VALUE;
        while (laenge == Integer.MIN_VALUE) {
            try {
                String line = scan.nextLine();
                laenge = Integer.parseInt(line.trim());
            } catch (NumberFormatException nfe) {
                System.out.println("Es ist kein Zahl. Geben Sie bitte Ihre alte ein!");
            }
        }
        System.out.println("Das Feld  ist " + laenge + " lang.");
        int pos = Math.round(laenge / 2.0f);
        printPlayfield(laenge, pos);
        while (!(pos <= 1 || pos >= laenge)) {
            pos = linksRechts(pos);
            printPlayfield(laenge, pos);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ie) { /* Ignore */ }
        }
        if (pos == laenge) {
            System.err.println("!!!!!GAME OVER!!!!!!");
            System.out.println("Rechter Rand erreicht");
        } else {
            System.err.println("!!!!!GAME OVER!!!!!");
            System.out.println("Linker Rand erreicht");
        }
    }

    private static int linksRechts(int pos) {
        int zufallzahl = random.nextInt(100);

        if (zufallzahl < 30) {
            pos--;
        } else if (zufallzahl < 60) {
            pos++;
        }
        return pos;
    }

    public static void printPlayfield(int laenge, int pos) {
        System.out.print("[");
        for (int i = 1; i < pos; i++) {
            System.out.print(".");
        }
        System.out.print("X");
        for (int i = pos + 1; i <= laenge; i++) {
            System.out.print(".");
        }
        System.out.println("]");
    }
}













