import java.util.Random;

/***
 * Um für das Wichteln an Weihnachten gerüstet zu sein, soll ein Programm entworfen werden,
 * das aus einer Liste (Array) von Namen, jedem dieser Namen einen Wichtel zuweist und auf der Konsole ausgibt.
 */
public class Wichteln {
    public static void main(String[] args) {
        String[] namen = {"Alex", "Bernd", "Claudia", "Doris", "Ernst", "Franz"};
        boolean pruefung = true;
        if (namen.length < 3) {                          //Prüfung: es braucht mindestens drei Namen
            System.err.println("Das Wichteln kann nicht richtig durchgeführt werden," +
                    " weil die Anzahl der Personen zu gering ist.");
            pruefung = false;
        }
        for (int i = 0; i < namen.length; i++) {        //Prüfung: kontrolle ob zweimal der gleiche Name vorkommt
            for (int j = i + 1; j < namen.length; j++) {
                if (namen[i].toUpperCase().equals(namen[j].toUpperCase())) {
                    System.err.println("Das Wichteln kann nicht richtig durchgeführt werden," +
                            " weil ein Name doppelt vorkommt.");
                    pruefung = false;
                }
            }
        }
        namenzufallsort(namen, pruefung);
        zuordnenWichtel(namen, pruefung);
    }

    private static void namenzufallsort(String[] namen, boolean pruefung) {
        Random ranWichtel = new Random();
        if (pruefung) {
            for (int i = 0; i < namen.length; i++) {
                int tempPos = ranWichtel.nextInt(namen.length); //zufall index auf tempPos
                String temp = namen[i];                         //zufall name auf temp
                namen[i] = namen[tempPos];                      //zufall index auf aktuelles [i]
                namen[tempPos] = temp;                          //name auf aktuelles[i]
            }
        }
    }

    private static void zuordnenWichtel(String[] namen, boolean pruefung) {
        if (pruefung) {
            for (int i = 0; i < namen.length - 1; i++) {
                System.out.println(namen[i] + " ist Wichtel von " + namen[i + 1]);
            }                   // Pos0 mit Pos1, Pos1 mit Pos2  usw.
            System.out.println(namen[namen.length - 1] + " ist Wichtel von " + namen[0]);
        }                           //der letzte Name wird mit dem ersten ausgewählt
    }
}
