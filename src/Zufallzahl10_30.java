import java.util.Random;

public class Zufallzahl10_30 {
    public static void main(String[] args) {

        int summe = 0;
        boolean loop = true;
        while (loop) {
            int zufallzahl = (int) (10 + (Math.random()) * 20);
            if (zufallzahl != 15 && zufallzahl != 25) {
                summe = summe + zufallzahl;
            } else {
                loop = false;
            }
            System.out.println(zufallzahl);
        }
        System.out.println("Die Summe der Zufallszahl ist \"" + summe + "\".");
    }
}
