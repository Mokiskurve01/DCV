package November;

public class Stundenliste {
    public static void main(String[] args) {

        String[][] hoursList = getHoursList();
        int stundenlohn = 8;
        int danielSumme = 0;
        int alexSumme = 0;
        int michaelSumme = 0;
        for (String[] strings : hoursList) {
            switch (strings[0]) {
                case "Daniel" -> {
                    String daniel = strings[1];
                    danielSumme += Integer.parseInt(daniel);
                }
                case "Alex" -> {
                    String alex = strings[1];
                    alexSumme += Integer.parseInt(alex);
                }
                case "Michael" -> {
                    String michael = strings[1];
                    michaelSumme += Integer.parseInt(michael);
                }
            }
        }
        System.out.println("Daniel bekommt " + danielSumme * stundenlohn + " Euro.");
        System.out.println("Alex bekommt " + alexSumme * stundenlohn + " Euro.");
        System.out.println("Michael bekommt " + michaelSumme * stundenlohn + " Euro.");
    }

    public static String[][] getHoursList() {
        return new String[][]{
                {"Daniel", "7"},
                {"Alex", "9"},
                {"Michael", "8"},
                {"Daniel", "5"},
                {"Daniel", "3"},
                {"Alex", "7"},
                {"Michael", "6"},
                {"Alex", "4"},
                {"Michael", "5"},
        };
    }
}
