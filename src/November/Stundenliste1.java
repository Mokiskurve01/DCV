package November;

public class Stundenliste1 {
    public static void main(String[] args) {

        String[][] stundenListe = getList();
        int stundenlohn = 8;
        int stundenPeter = 0;
        int stundenHans = 0;
        int stundenMonika = 0;
        for (String[] strings : stundenListe) {
            switch (strings[0]) {
                case "Peter" -> stundenPeter += Integer.parseInt(strings[1]);
                case "Hans" -> stundenHans += Integer.parseInt(strings[1]);
                case "Monika" -> stundenMonika += Integer.parseInt(strings[1]);
            }
        }
        System.out.println("Peter " + stundenPeter * stundenlohn + " €");
        System.out.println("Hans " + stundenHans * stundenlohn + " €");
        System.out.println("Monika " + stundenMonika * stundenlohn + " €");
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