import java.util.Scanner;

public class Bankomat {


    public static void main(String[] args) {
        boolean aktive = true;
        int kontostand = 0;
        while (aktive) {
            int menue = auswahlMenue();
            switch (menue) {
                case 1 -> zeigeKontostand1(kontostand);
                case 2 -> kontostand = einzahlung2(kontostand);
                case 3 -> kontostand = auszahlung3(kontostand);
                case 0 -> {
                    beenden0();
                    aktive = false;
                }
            }
        }
    }

    private static int auszahlung3(int kontostand) {
        System.out.println("Bitte geben Sie Auszahlungsbetrag ein.");
        Scanner scan = new Scanner(System.in);
        int auszahlung = scan.nextInt();
        if (kontostand >= auszahlung) {
            kontostand = kontostand - auszahlung;
            System.out.println("Auszahlung war erfolgreich\n" +
                    "Neuer Kontostand lautet " + kontostand + "Euro.");
        }
        return kontostand;
    }

    private static int einzahlung2(int kontostand) {
        System.out.println("Bitte geben Sie Einzahlungsbetrag ein.");
        Scanner scan = new Scanner(System.in);
        int einzahlung = scan.nextInt();
        kontostand = kontostand + einzahlung;
        System.out.println("Einzahlung erfolgreich" +
                "\nDer neue Kontostand lautet " + kontostand + " Euro.");
        return kontostand;
    }

    private static void zeigeKontostand1(int kontostand) {
        System.out.println("Der aktuelle Kontostand beträgt " + kontostand + " Euro.");
    }

    private static void beenden0() {
        System.out.println("Vielen dank für Ihren Besuch.");
    }

    private static int auswahlMenue() {
        while (true) {
            System.out.println("Drücken Sie bitte :");
            System.out.println("1 = Kontostand \n2 = Einzahlung \n3 = Auszahlung \n0 = Beenden \n");
            Scanner eingabe = new Scanner(System.in);

            if (eingabe.hasNextInt()) {
                int eingabefasch = eingabe.nextInt();
                if (eingabefasch <= 3) {
                    return eingabefasch;
                }
            }
            System.err.println("Die Eingabe wurde leider nicht erkanntn, versuchen Sie es bitte nocheinmal.");
        }

    }
}
