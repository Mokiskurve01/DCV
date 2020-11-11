package November;

public class Stundenliste2 {
    public static void main(String[] args) {

        String[][] stundenListe = getList();
        int stundenlohn = 8;
        int[] summe = getSumme(stundenListe);
        print(stundenlohn, summe);
    }

    private static void print(int stundenlohn, int[] summe) {
        System.out.println("Peter " + summe[0] * stundenlohn + " €");
        System.out.println("Hans " + summe[1] * stundenlohn + " €");
        System.out.println("Monika " + summe[2] * stundenlohn + " €");
    }

    private static int[] getSumme(String[][] stundenListe) {
        int[] summe = new int[3];
        for (String[] strings : stundenListe) {
            switch (strings[0]) {
                case "Peter" -> summe[0] += Integer.parseInt(strings[1]);
                case "Hans" -> summe[1] += Integer.parseInt(strings[1]);
                case "Monika" -> summe[2] += Integer.parseInt(strings[1]);
            }
        }
        return summe;
    }

    private static String[][] getList() {
        return new String[][]{
                {"Peter", "15"},
                {"Hans", "10"},
                {"Monika", "7"},
                {"Hans", "6"},
                {"Peter", "-3"},
                {"Monika", "2"},
                {"Monika", "5"},
                {"Hans", "3"},
                {"Peter", "7"},
        };
    }
}