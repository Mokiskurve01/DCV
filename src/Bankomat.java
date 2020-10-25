import java.util.Scanner;

/***
 * Aufgabe Bankomat
 * Diese Aufgabe setzt sich aus allen gelernten Inhalten zusammen!
 *
 * Erstelle ein Programm, das einen Bankomaten simuliert. Folgende Möglichkeiten gibt es:
 * 1. Einzahlen
 * 2. Abheben
 * 3. Kontostand
 * 4. Beenden
 * -------------------Zusatz Aufgabe----------------------
 * 5. Pin Eingabe(Drei Vesuche)
 * 6. Einzahlung nur Banknoten möglich
 * 7. Auszahlung nur ein vielfaches von 10
 * 8. Beleg Ausdrucken
 */
public class Bankomat {
    public static void main(String[] args) {
        pin();
        boolean aktive = true;
        int kontostand = 0;
        while (aktive) {
            int menue = auswahlMenue();
            switch (menue) {
                case 1 -> kontostand1(kontostand);
                case 2 -> kontostand = einzahlung2(kontostand);
                case 3 -> kontostand = auszahlung3(kontostand);
                case 0 -> {
                    beenden0();
                    aktive = false;
                }
            }
        }
        beleg();
    }

    private static void beleg() {
        System.out.println("Möchten Sie einen Beleg?\n" +
                "Ja/Nein");
        Scanner scanBeleg = new Scanner(System.in);
        String beleg = scanBeleg.nextLine().toUpperCase();
        if (beleg.equals("JA")) {
            System.out.println("Hier haben Sie Ihren Beleg.");
        } else {
            System.out.println("Vielen dank für Ihren Besuch.(Ohne Beleg)");
        }
    }

    private static void pin() {
        for (int i = 1; i <= 3; i++) {
            int aktiverPin = 1234;
            System.out.println("Bitte geben Sie Ihren Pin ein.");
            Scanner scanPin = new Scanner(System.in);
            int eingabePin = scanPin.nextInt();
            if (aktiverPin == eingabePin) {
                System.out.println("Eingabe war erfolgreich.");
                break;
            } else if (i == 3) {
                System.err.println("Sie hatten drei Fehlversuche Karte wird eingezogen.");
                beenden0();
            } else {
                System.out.println("Falscher Pin!!!");
            }
        }
    }

    private static int auswahlMenue() {
        while (true) {
            System.out.println("Drücken Sie bitte :");
            System.out.println("1 = Kontostand \n2 = Einzahlung \n3 = Auszahlung \n0 = Beenden \n");
            Scanner eingabe = new Scanner(System.in);

            if (eingabe.hasNextInt()) {
                int eingabefalsch = eingabe.nextInt();
                if (eingabefalsch <= 3) {
                    return eingabefalsch;
                }
            }
            System.err.println("Die Eingabe wurde leider nicht erkanntn, versuchen Sie es bitte nocheinmal.");
        }
    }

    private static void beenden0() {
        System.out.println("Vielen dank für Ihren Besuch.");
    }

    private static void kontostand1(int kontostand) {
        System.out.println("Der aktuelle Kontostand beträgt " + kontostand + " Euro.");
    }

    private static int einzahlung2(int kontostand) {
        System.out.println("Bitte geben Sie ihren Einzahlungsbetrag ein.");
        Scanner scan = new Scanner(System.in);
        int einzahlung = scan.nextInt();
        if (einzahlung % 5 == 0) {
            kontostand = kontostand + einzahlung;
            System.out.println("Einzahlung vom " + einzahlung + " Euro erfolgreich." +
                    "\nDer neue Kontostand lautet " + kontostand + " Euro.");
        } else {
            System.out.println("Ihr Einzahlungsbetrag ist nicht möglich.\n" +
                    "Es werden nur Banknoten akzeptiert!");
        }
        return kontostand;
    }

    private static int auszahlung3(int kontostand) {
        System.out.println("Bitte geben Sie Auszahlungsbetrag ein.");
        Scanner scan = new Scanner(System.in);
        int auszahlung = scan.nextInt();
        if (auszahlung % 10 == 0) {
            if (kontostand >= auszahlung) {
                kontostand = kontostand - auszahlung;
                System.out.println("Auszahlung war erfolgreich\n" +
                        "Neuer Kontostand lautet " + kontostand + " Euro.");
            } else {
                System.out.println("Ihr Auszahlung ist nicht möglich.\n" +
                        " Minimum Auszahlung 10 Euro und nur Banknoten!");
            }
        }
        return kontostand;
    }
}
