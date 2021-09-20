import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSumOf2x2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] matrixData = readArray(scan, ", ");
        int rows = matrixData[0];
        int columns = matrixData[1];

        int[][] matrix = readMatrix(rows, columns, ", ", scan);

        int maxSum = 0;
        int[][] matrixWithBiggestSum = new int[2][2];
        for (int k = 0; k < rows - 1; k++) {
            for (int i = 0; i < columns-1; i++) {
                int[][] currentSubmatrix = readSubmatrix(matrix, k, i);
                int currentMatrixSum = findSumOfMatrix(currentSubmatrix);

                if(currentMatrixSum > maxSum){
                    matrixWithBiggestSum = currentSubmatrix;
                    maxSum = currentMatrixSum;
                }
            }
        }

        printMatrix(matrixWithBiggestSum);
        System.out.println(maxSum);

    }

    public static int findSumOfMatrix(int[][] matrix){
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

    public static int[][] readSubmatrix (int[][] matrix, int currentRow, int currentColumn){
        int [][] currentSubmatrix = new int[2][2];

        int row = 0;
        for (int i = currentRow; i < currentRow +2; i++) {
            int column = 0;
            for (int j = currentColumn; j < currentColumn + 2; j++) {

                if(i < matrix.length && j < matrix[0].length){
                    currentSubmatrix[row][column] = matrix[i][j];
                }

                column++;
            }

            row++;
        }

        return currentSubmatrix;
    }

    public static int[][] readMatrix(int rows, int columns, String delimiter, Scanner scan){
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] currentRow = readArray(scan, delimiter);

            matrix[i] = currentRow;
        }

        return matrix;
    }

    public static int[] readArray(Scanner scan, String delimiter){
        return Arrays
                .stream(scan.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void printMatrix(int [][] matrix){
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
}
