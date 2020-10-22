import java.util.Random;

public class ZufallGenaratorWoerter {
    private static final Random random = new Random();

    public static void main(String[] args) {
        String[] words = {"Apfel", "Birne", "Cocusnuss", "Dateln", "Erbeeren", "Kiwi"};

        for (int i = 0; i < 10; i++) {
            System.out.println("Zufall(" + i + "): " + words[random.nextInt(words.length)]);
        }
    }
}
