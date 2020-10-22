import java.util.Random;

public class ZufallGenarator {

    private static final Random random=new Random();

    public static void main(String[]args){
        for (int i = 0; i < 10; i++) {
            System.out.println("Zufall("+i+"):"+random.nextInt(100));

        }
    }

}
