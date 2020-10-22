import java.util.Random;

public class RandomLinsRechtsSchritte {

    private static final Random random = new Random();

    public static void main(String[] args) {
        int width = 20;
        int pos = Math.round(width / 2.0f);
        boolean loop = true;
        printPlayfield(width, pos);
        while (loop) {
            pos = stehenLinksRechts(pos);
            printPlayfield(width, pos);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ie) { /* Ignore */ }
            if (pos == 0 || pos == 20) {
                loop = false;
            }
        }
        if (pos == 20) {
            System.err.println("!!!!!GAME OVER!!!!!!");
            System.out.println("Rechte Rand erreicht");
        } else {
            System.err.println("!!!!!GAME OVER!!!!!");
            System.out.println("Linke Rand erreicht");
        }
    }

    private static int stehenLinksRechts(int pos) {
        int zufallzahl = random.nextInt(100);
        //System.out.println(zufallzahl);
        if (zufallzahl < 30) {
            pos--;
        } else if (zufallzahl < 60) {
            pos++;
        }
        return pos;
    }

    public static void printPlayfield(int width, int pos) {
        System.out.print("[");
        for (int i = 1; i <= pos; i++) {
            System.out.print(".");
        }
        System.out.print("X");
        for (int i = pos + 1; i <= width; i++) {
            System.out.print(".");
        }
        System.out.println("]");
    }
}













