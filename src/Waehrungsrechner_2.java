import java.util.Scanner;

public class Waehrungsrechner_2 {




    public static void main(String[] args) {
        double wechselkurs = 0D;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welche Währung möchten Sie Wechseln?" +
                "\n         Drücken Sie:");
        System.out.println(
                "     \" S \"-für Schweizer Franken" +
                        "\n     \" U \"-für US-Dollar" +
                        "\n     \" B \"-für Bitcoin");
        String waehrung = scan.nextLine().toUpperCase();
        System.out.println("Welchen Euro Betrag möchten Sie Wechseln?");
        int betrag = scan.nextInt();
        switch (waehrung) {
            case "S" -> wechselkurs = 1.07;
            case "U" -> wechselkurs = 1.19;
            case "B" -> wechselkurs = 0.000093;
            default -> System.err.println("Der von Ihnen eingegebene Buchstabe wurde leider nicht erkannt.\n" +
                    "Bitte versuchen Sie es erneut und vergewissern Sie sich das Sie den Buchstaben gross Eingeben!");
        }
        System.out.println(betrag * wechselkurs);
    }

}
