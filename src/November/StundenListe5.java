package November;


public class StundenListe5 {
    public static void main(String[] args) {

        String[][] stundenliste = SimpleCSVReader.readCSV("C:\\Users\\DCV\\IdeaProjects\\Stunden2.csv", ",");

        double stundenLohn = 8.34;
        pruefungListe(stundenliste);
        String[] mitarbeiter = anzahlNamen(stundenliste);
        stundenSumme(stundenliste, stundenLohn, mitarbeiter);
    }

    private static void stundenSumme(String[][] stundenliste, double stundenLohn, String[] mitarbeiter) {
        for (String s : mitarbeiter) {
            double summeStd = 0;
            int arbeitsTage = 0;
            for (String[] strings : stundenliste) {
                if (s.equals(strings[0]) && strings[1] != null) {
                    summeStd += Double.parseDouble(strings[1]);
                    arbeitsTage++;
                }
            }
            print(stundenLohn, s, summeStd, arbeitsTage);
        }
    }

    private static void print(double stundenLohn, String s, double summeStd, int arbeitsTage) {
        if (arbeitsTage > 0) {
            double durchschnitt = (summeStd * stundenLohn) / arbeitsTage;
            durchschnitt = Math.round(100.0 * durchschnitt) / 100.0;
            double gesamtlohn = summeStd * stundenLohn;
            gesamtlohn = Math.round(100.0 * gesamtlohn) / 100.0;
            System.out.println("Name: " + s + "\n" +
                    "Anzahl Arbeitstage : " + arbeitsTage + "\n" +
                    "Anzahl Stunden: " + summeStd + "\n" +
                    "Gesamtlohn: € " + gesamtlohn + "\n" +
                    "Tagslohn: € " + durchschnitt);
        } else {
            System.out.println(s + ":Hat keine Stunden eingetragen.");
        }
        System.out.println("======================================");
    }

    private static void pruefungListe(String[][] stundenLieste) {
        for (int i = 0; i < stundenLieste.length; i++) {
            if (!stundenLieste[i][1].matches("\\d+(\\.\\d+)?")) {
                System.err.println("In Zeile " + i + " (" + stundenLieste[i][0] + stundenLieste[i][1] + ") ist nicht korrekt!");
                stundenLieste[i][1] = null;
            }
        }
    }

    public static String[] anzahlNamen(String[][] stundenListe) {
        StringBuilder namenListe = new StringBuilder("%");
        for (int i = 1; i < stundenListe.length; i++) {
            if (!namenListe.toString().contains("%" + stundenListe[i][0] + "%")) {
                namenListe.append(stundenListe[i][0]).append("%");
            }
        }
        return namenListe.substring(1).split("%");
    }
}

