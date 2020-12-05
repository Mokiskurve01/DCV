package Fotoapparat;

import java.util.Date;
import java.util.GregorianCalendar;

public class Camera {
    private String type;
    private double megapixel;
    private Date releaseDate;
    private int focalLengthMin;
    private int focalLengthMax;

    public Camera(String type, double megapixel, Date releaseDate, int focalLengthMin, int focalLengthMax) {
        this.type = type;
        this.megapixel = megapixel;
        this.releaseDate = releaseDate;
        this.focalLengthMin = focalLengthMin;
        this.focalLengthMax = focalLengthMax;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return type +
                ": megapixel = " + megapixel + "MP" +
                ", releaseDate = " + releaseDate +
                ", focalLength = " + focalLengthMin + "mm - " + focalLengthMax + "mm";
    }

    public static void main(String[] args){
        Camera canonEos5D = new Camera("Canon EOS 5D", 12.8, new GregorianCalendar(2005, 8, 1).getTime(), 24, 105);
        System.out.println(canonEos5D);
    }
}
