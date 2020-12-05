package Mensch;

public class Main {
    public static void main(String[] args) {
        Mensch m = new Mensch("Alexander", "Moik", "Feldkirch", "Männlich", 1978);
        Mensch m2 = new Mensch("Alexander", "Moik", "Bregenz", "Männlich", 1976);


        printMensch(m);
        printMensch(m2);
        printMensch(m);
        System.out.println(m.toString());
        System.out.println(m.equals(m2));
        System.out.println(m.getClass().getName());
        System.out.println(m.getClass().getSimpleName());
    }

    private static void printMensch(Mensch mensch) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10d%n",
                mensch.getVorname(),
                mensch.getNachname(),
                mensch.getGeburtsort(),
                mensch.getGeschlecht(),
                mensch.getGeburtsjahr());
    }
}
