package November;

import java.util.Arrays;

public class Array2d_int {
    public static void main(String[] args) {
        int[][] myField = initArray(21, 21);
        drawSquare(myField, 11);
        printField(myField);
    }

    public static void drawSquare(int[][] field, int size) {
        int startZeile = Math.round((field.length - size) / 2f);
        for (int i = 0; i < size; i++) {
            field[startZeile][startZeile + i] = '1';
            field[startZeile + i][startZeile] = '2';
            field[startZeile + size - 1][startZeile + i] = '3';
            field[startZeile + i][startZeile + size - 1] = '4';
        }
    }
    public static int[][] initArray(int rows, int columns) {
        int[][] retVal = new int[rows][columns];
        for (int[] chars : retVal) {
            Arrays.fill(chars, '.');
        }
        retVal[0][0]='+';
        retVal[0][retVal.length-1]='X';
        retVal[retVal.length-1][0]='Y';
        for (int i = 1; i <retVal.length-1 ; i++) {
            retVal[i][0]='|';
            retVal[0][i]='-';
        }
        return retVal;
    }
    public static void printField(int[][] field) {
        for (int[] chars : field) {
            for (int aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
