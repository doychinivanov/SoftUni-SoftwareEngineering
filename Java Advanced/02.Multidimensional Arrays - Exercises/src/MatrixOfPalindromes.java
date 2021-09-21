import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int[] matrixData = readIntArray("\\s+", scan);

        int rows = matrixData[0];
        int cols = matrixData[1];

        String[][] matrix = new String[rows][cols];

        fillMatrixWithPalindromes(matrix);

        printMatrix(matrix);
    }

    public static void fillMatrixWithPalindromes(String[][] matrix){
        char initialChar = 'a';

        for (int row = 0; row < matrix.length ; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                char secondChar = (char)(initialChar + col);

                String palindrome = "" + initialChar + secondChar + initialChar;

                matrix[row][col] = palindrome;
            }

            initialChar = (char)(initialChar + 1);
        }
    }

    public static void printMatrix(String [][] matrix){
        ArrayList<String> matrixRows = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            StringBuilder currentRow = new StringBuilder();

            for (int j = 0; j < matrix[i].length; j++) {
                currentRow.append(matrix[i][j] + " ");
            }

            matrixRows.add(currentRow.toString());
        }

        System.out.println(String.join("\n", matrixRows));
    }

    public static int[] readIntArray(String delimiter, Scanner scan){
        return Arrays
                .stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
