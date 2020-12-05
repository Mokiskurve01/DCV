package November;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;

public class HaushaltsbudgetFeldkirch2019_1 {
    public static void main(String[] args) {

        //#1 Einlesen der CSV Daten als zweidimensionales String Array
        String[][] haushaltsbudgetListe = SimpleCSVReader.readCSV("C:\\Users\\DCV\\IdeaProjects\\offenerhaushalt_fk_2019.csv", ";");

        //#2 irrelevante Einträge (Überschriften, voranschlag-rj=0) markieren/ignorieren oder löschen
        String[][] correctedList = correctedList(haushaltsbudgetListe);

        //#3 Gesamtbudget 2019 (Summe aller Einzelposten)
        int gesamtSumme = 0;
        gesamtSumme = getGesamtSumme(correctedList, gesamtSumme);
        DecimalFormat df = decimalFormatSymbols();
        printGesamtSumme(gesamtSumme, df);

        //#4 Top 10 der größten Einzelposten
        sortList(correctedList);
        printMax(correctedList);

        //5# Top 10 der kleinsten Einzelposten
        printMin(correctedList);

        //6# Ausgaben für Schulen (Volksschulen, Mittelschulen, Poly)
        //7# Anteil Ausgaben für Schulen  in % am Gesamtbudget
        double prozent;
        int summe = 0;
        searchWord(correctedList, gesamtSumme, df, summe);

        //8# Ausgaben für Kindergärten - ansatzbezeichnung enthält "Kindergarten", "Ganztagskindergarten"
        //9# Anteil Ausgaben für Kindergärten in % am Gesamtbudget
        double prozent2;
        int summe2 = 0;
        searchWord2(correctedList, gesamtSumme, df, summe2, "Kindergarten, Ganztagskindergarten", "8#--------->", "9#--------->");
    }

    private static void searchWord2(String[][] correctedList, int gesamtSumme, DecimalFormat df, int summe2, String s, String s2, String s3) {
        double prozent2;
        String suchWort2 = s;
        String[] arr2 = suchWort2.split(", ");

        for (int i = 0; i < arr2.length; i++) {
            for (int n = 0; n < correctedList.length; n++) {
                if (correctedList[n][0].toLowerCase().contains(arr2[i].toLowerCase())) {
                    summe2 += Integer.parseInt(correctedList[n][2]);
                }
            }
        }
        System.out.println();
        System.out.print(s2);
        System.out.println("Aufwände für " + Arrays.toString(arr2) + ": €" + df.format(summe2));
        prozent2 = (double) summe2 / gesamtSumme * 100;
        System.out.print(s3);
        System.out.println("Das sind " + Math.round((prozent2) * 100) / 100d + "% des Gesamtbudgets");
    }

    private static void searchWord(String[][] correctedList, int gesamtSumme, DecimalFormat df, int summe) {
        double prozent;
        searchWord2(correctedList, gesamtSumme, df, summe, "Volksschule, Mittelschule, Polytechnische", "6#--------->", "7#--------->");
    }

    private static void printGesamtSumme(int gesamtSumme, DecimalFormat df) {
        System.out.println();
        System.out.print("3#--------->");
        System.out.println("Gesamtsumme: " + df.format(gesamtSumme) + " €.");
    }

    private static int getGesamtSumme(String[][] correctedList, int gesamtSumme) {
        for (int i = 0; i < correctedList.length; i++) {
            gesamtSumme += Integer.parseInt(correctedList[i][2]);
        }
        return gesamtSumme;
    }

    private static void printMin(String[][] correctedList) {
        System.out.println();
        System.out.print("5#--------->");
        System.out.println("Die 10 kleinsten Einzelposten");
        for (int i = correctedList.length - 1; i > correctedList.length - 11; i--) {
            System.out.println(correctedList[i][0] + "," + correctedList[i][1] + ", €" + correctedList[i][2]);
        }
    }

    private static void printMax(String[][] correctedList) {
        System.out.println();
        System.out.print("4#--------->");
        System.out.println("Die 10 größten Einzelposten");
        for (int i = 0; i < 10; i++) {
            System.out.println(correctedList[i][0] + "," + correctedList[i][1] + ", €" + correctedList[i][2]);
        }
    }

    private static void sortList(String[][] correctedList) {
        for (int i = 0; i < correctedList.length - 1; i++) {
            for (int k = i + 1; k < correctedList.length; k++) {
                if (Integer.parseInt(correctedList[i][2]) < (Integer.parseInt(correctedList[k][2]))) {
                    for (int l = 0; l < 3; l++) {
                        String temp = correctedList[i][l];
                        correctedList[i][l] = correctedList[k][l];
                        correctedList[k][l] = temp;
                    }
                }
            }
        }
    }

    private static DecimalFormat decimalFormatSymbols() {
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setGroupingSeparator('\'');
        dfs.setDecimalSeparator('_');
        DecimalFormat df = new DecimalFormat("###,###,###", dfs);
        return df;
    }

    private static String[][] correctedList(String[][] haushaltsbudgetListe) {
        int zaehler = 0;//Zählt alle Zeilen groeßer "0"
        for (int i = 1; i < haushaltsbudgetListe.length; i++) {//ohne erst Zeile(Überschrift)
            if (!haushaltsbudgetListe[i][2].startsWith("0")) {
                zaehler++;
            }
        }
        System.out.print("1#-2#------>");
        System.out.println(zaehler + " Zeilen in der korrigierten Liste.");
        String[][] correctedList = new String[zaehler][3]; //Neues Array mit Größe von der korrList
        int j = 0;
        for (int i = 1; i < haushaltsbudgetListe.length; i++) { //Befüllt das neue Array
            if (!haushaltsbudgetListe[i][2].startsWith("0")) {
                correctedList[j] = haushaltsbudgetListe[i];         //!!!!!!!!!!!!!warum geht das ohne 2DArray??????????????????????
                j++;
            }
        }
        return correctedList;
    }
}