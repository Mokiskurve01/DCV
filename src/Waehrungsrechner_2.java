import java.util.Scanner;

public class Waehrungsrechner_2 {

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Guten Tag." +
                    "\nWelche Währung möchten Sie Wechseln?" +
                    "\n         Drücken Sie:");
            System.out.println(
                    "     \" S \"-für Schweizer Franken" +
                            "\n     \" U \"-für US-Dollar" +
                            "\n     \" B \"-für Bitcoin");
            String waehrung = scan.nextLine().toUpperCase();
            switch (waehrung) {
                case "S" -> waehrung = "Schweizer Franken";
                case "U" -> waehrung = "US-Doller";
                case "B" -> waehrung = "Bitcoin";
                default -> System.err.println("Der von Ihnen eingegebene Buchstabe wurde leider nicht erkannt.\n" +
                        "Bitte versuchen Sie es erneut !");
            }
            System.out.println("Welchen Betrag möchtest du in " + waehrung + " Wechseln?");
            int betrag = scan.nextInt();
            double wechselkurs = 0D;
            switch (waehrung) {
                case "Schweizer Franken" -> wechselkurs = 1.07;
                case "US-Doller" -> wechselkurs = 1.19;
                case "Bitcoin" -> wechselkurs = 0.000093;
                default ->waehrung="abbruch";
            }
            if (waehrung.equals("abbruch")){
                System.err.println("Der von Ihnen eingegebene Buchstabe wurde leider nicht erkannt.\n" +
                        "Bitte versuchen Sie es erneut !");
            }else {
                System.out.println("Sie bekommen " + betrag * wechselkurs + " " + waehrung + ".");
                System.out.println("Möchten Sie noch mal Wechseln?");
                System.out.println("Ja/Nein");
            }

            Scanner scan1 = new Scanner(System.in);
            String ende = scan1.nextLine().toUpperCase();
            if (!ende.equals("JA")) {
                ende = "NEIN";
            }
            if (ende.equals("NEIN")) {
                loop = false;
            }
            System.out.println("Vielen dank bis zum nächsten Mal.");
        }
    }
}
