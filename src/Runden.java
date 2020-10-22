import java.sql.SQLOutput;

public class Runden {
    public static void main(String[] args) {

        float[] values = {1.0f, 1.15f, 1.5f, 1.91f, 11f, 19f, 120f};
        for (float f : values) {
            System.out.print(f + ", ");
            System.out.print(Math.round(f) + ", ");//bei 5 aufrunden
            System.out.print(Math.floor(f) + ", ");//abrunden
            System.out.print(Math.ceil(f));//aufrunden
            System.out.println();
        }

        System.out.println("Test Github");
    }
}
