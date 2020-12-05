package November;

public class HaushaltsbudgetFeldkirch2019 {
    public static void main(String[] args) {

        String[][] haushaltsbudgetListe = SimpleCSVReader.readCSV("C:\\Users\\DCV\\IdeaProjects\\offenerhaushalt_fk_2019.csv", ";");
        // listeKorrigieren(haushaltsbudgetListe);
        // printGesamteListe(haushaltsbudgetListe);
        // gesamtBugtet(haushaltsbudgetListe);
         String[][] copyListe = haushaltsbudgetListe;


        int zaehler = 0;
        for (int i = 0; i < haushaltsbudgetListe.length; i++) {
            if (!haushaltsbudgetListe[i][2].startsWith("0") && haushaltsbudgetListe[i][2].matches("\\d+(\\.\\d+)?")) {
                zaehler++;
            }
        }
        System.out.println(zaehler);

        String[]cleanList=new String[zaehler];
        for (int i = 0; i <haushaltsbudgetListe.length; i++) {
            if (!haushaltsbudgetListe[i][2].startsWith("0") && haushaltsbudgetListe[i][2].matches("\\d+(\\.\\d+)?")){

            }

        }


       for (int i = 1; i < copyListe.length; i++) {
            for (int j = i + 1; j < copyListe.length; j++) {
                if (Integer.parseInt(copyListe[i][2]) < (Integer.parseInt(copyListe[j][2]))) {
                    copyListe[0][0] = copyListe[i][2];
                    copyListe[i][2] = copyListe[j][2];
                    copyListe[j][2] = copyListe[0][0];
                }
            }
        }
        System.out.println();
        System.out.println("------------10 der größten Einzelposten-----------");

        for (int i = 1; i <= 10; i++) {
            System.out.println(copyListe[i][0] + "," + copyListe[i][1] + ", €" + copyListe[i][2]);
        }
        System.out.println();
        System.out.println("------------10 der kleinsten Einzelposten-----------");
        int counter = 10;
        for (int i = copyListe.length - 1; i > 1; i--) {
            if (counter >= 1) {
                if (!copyListe[i][2].equals("0")) {
                    counter--;
                    System.out.println(copyListe[i][0] + "," + copyListe[i][1] + ", €" + copyListe[i][2]);
                }
            }
        }



      /*  for (String[] zeile : copyListe) {
            for (String aString : zeile) {
                System.out.print(aString);
            }
            System.out.println();
        }
       */
    }

    private static void gesamtBugtet(String[][] haushaltsbudgetListe) {
        int summe = 0;
        for (String[] strings : haushaltsbudgetListe) {
            if (strings[2] != null) {
                summe += Integer.parseInt(strings[2]);
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Im Jahr 2019 beträgt die Höhe des Haushaltsbudget von Feldkirch  : " + summe + " €");
        System.out.println("=============================================================================");
    }

    private static void listeKorrigieren(String[][] haushaltsbudgetListe) {
        for (int i = 0; i < haushaltsbudgetListe.length; i++) {
            if (haushaltsbudgetListe[i][2].matches("\\d+(\\.\\d+)?") && !haushaltsbudgetListe[i][2].equals("0")) {
                continue;
            }
            //    System.err.println("Bei der Zeile " + i + " Spalte 2 (" + haushaltsbudgetListe[i][2] + ") ist keine Wert vorhanden.");
            haushaltsbudgetListe[i][2] = null;
        }
    }


    private static void printGesamteListe(String[][] haushaltsbudgetListe) {
        for (String[] zeile : haushaltsbudgetListe) {
            for (String aSting : zeile) {
                System.out.print(aSting);
            }
            System.out.println();
        }
    }
}
