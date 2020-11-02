package November;

public class Stundenliste1 {
    public static void main(String[] args) {

        String[][] hourList = getList();
        int[] hoursSum = getInts(hourList);
        int[] salary = hoursSum(hoursSum);
        printLoan(salary);
    }

    private static void printLoan(int[] salary) {
        System.out.println("Alex bekommt " + salary[0] + "€ ausbezahlt.");
        System.out.println("Daniel bekommt " + salary[1] + "€ ausbezahlt.");
        System.out.println("Michael bekommt " + salary[2] + "€ ausbezahlt.");
    }

    private static int[] hoursSum(int[] hoursSum) {
        int loanPerHour = 8;
        int[] salary = new int[3];
        for (int i = 0; i < hoursSum.length; i++) {
            salary[i] = hoursSum[i] * loanPerHour;
        }
        return salary;
    }

    private static int[] getInts(String[][] hourList) {
        int[] hoursSum = new int[3];
        for (String[] entry : hourList) {
            String name = entry[0];
            int hoursSumIndex = switch (name) {
                case "Alex" -> 0;
                case "Daniel" -> 1;
                case "Michael" -> 2;
                default -> 0;
            };
            hoursSum[hoursSumIndex] = hoursSum[hoursSumIndex] + Integer.parseInt(entry[1]);
        }
        return hoursSum;
    }

    private static String[][] getList() {
        return new String[][]{{"Daniel", "7"},
                {"Alex", "9"},
                {"Michael", "8"},
                {"Daniel", "5"},
                {"Daniel", "3"},
                {"Alex", "7"},
                {"Michael", "6"},
                {"Alex", "4"},
                {"Michael", "5"}};
    }
}