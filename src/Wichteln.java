import java.util.Random;

/***
 * Um für das Wichteln an Weihnachten gerüstet zu sein,
 * soll ein Programm entworfen werden,
 * das aus einer Liste (Array) von Namen,
 * jedem dieser Namen einen Wichtel zuweist und auf der Konsole ausgibt.
 */
public class Wichteln {
    public static void main(String[] args) {
        String[] namenOrg = {"Alex ", "Bernd "};
        String[] namenZufall;
        namenZufall = namenOrg;
        istWichtelmoeglich(namenZufall);
        namenzufallsort(namenZufall);
        zuordnenWichtel(namenZufall);
    }

    private static void istWichtelmoeglich(String[] namenZufall) {
        if (namenZufall.length < 3) {                          //Prüfung: es braucht mindestens zwei Namen
            System.err.println("Das Wichteln kann nicht richtig durchgeführt werden, weil die Anzahl der Personen zu gering ist.");
        }                                                      //möchte noch ein gesamt break einfügen
    }

    private static void namenzufallsort(String[] namenZufall) {
        Random ranWichtel = new Random();

        for (int i = 0; i < namenZufall.length; i++) {
            int tempPos = ranWichtel.nextInt(namenZufall.length); //zufall index auf tempPos
            String temp = namenZufall[i];                         //zufall name auf temp
            namenZufall[i] = namenZufall[tempPos];                //zufall index auf aktuelles [i]
            namenZufall[tempPos] = temp;                          //name auf aktuelles[i]
        }
    }

    private static void zuordnenWichtel(String[] namenZufall) {

            for (int i = 0; i < namenZufall.length - 1; i++) {
                System.out.println(namenZufall[i] + "ist Wichtel von " + namenZufall[i + 1]);
            }
            System.out.println(namenZufall[namenZufall.length - 1] + "ist Wichtel von " + namenZufall[0]);
    }
}
