import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int[] matrixData = readArray(scan, ", ");
        int rows = matrixData[0];
        int columns = matrixData[1];

        int[][] matrix = readMatrix(rows, columns, ", ", scan);

        System.out.println(rows);
        System.out.println(columns);
        System.out.println(findSumOfMatrix(matrix));
    }

    public static int findSumOfMatrix(int[][] matrix){
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += findSumOfArray(matrix[i]);
        }

        return sum;
    }

    public static int findSumOfArray(int[] arr){
        int sum = 0;

        for (int number: arr) {
            sum += number;
        }

        return sum;
    }

    public static int[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = readArray(scan, ", ");

            System.arraycopy(currentRow, 0, matrix[i], 0, currentRow.length);
        }

        return matrix;
    }

    public static int[] readArray(Scanner scan, String delimiter){
        return Arrays
                .stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
