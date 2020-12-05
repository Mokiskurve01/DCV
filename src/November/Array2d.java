package November;

import java.util.Arrays;

public class Array2d {
    public static void main(String[] args) {
        char[][] myField = initArray(21, 21);
        drawSquare(myField, 11);
        printField(myField);
    }

    public static void drawSquare(char[][] field, int size) {
        int startZeile = Math.round((field.length - size) / 2f);
        for (int i = 0; i < size; i++) {
            field[startZeile][startZeile + i] = '1';
            field[startZeile + i][startZeile] = '2';
            field[startZeile + size - 1][startZeile + i] = '3';
            field[startZeile + i][startZeile + size - 1] = '4';
        }
    }
    public static char[][] initArray(int rows, int columns) {
        char[][] retVal = new char[rows][columns];
        for (char[] chars : retVal) {
            Arrays.fill(chars, ' ');
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
    public static void printField(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
